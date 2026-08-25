package com.fundoonotes.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoonotes.dto.NotesRequest;
import com.fundoonotes.dto.NotesResponse;
import com.fundoonotes.entity.Label;
import com.fundoonotes.entity.Notes;
import com.fundoonotes.entity.User;
import com.fundoonotes.exception.BusinessException;
import com.fundoonotes.exception.ResourceNotFoundException;
import com.fundoonotes.messaging.ExportEventPublisher;
import com.fundoonotes.messaging.ExportRequestEvent;
import com.fundoonotes.messaging.NoteJmsPublisher;
import com.fundoonotes.repository.LabelRepository;
import com.fundoonotes.repository.NotesRepository;
import com.fundoonotes.repository.UserRepository;

@Service
public class NotesServiceImpl implements NotesService {

    private static final Logger log =
            LoggerFactory.getLogger(
                    NotesServiceImpl.class
            );

    private final NotesRepository notesRepository;
    private final UserRepository userRepository;
    private final LabelRepository labelRepository;
    private final ExportEventPublisher exportEventPublisher;
    private final NotesCacheService notesCacheService;
    private final NoteJmsPublisher noteJmsPublisher;

    public NotesServiceImpl(
            NotesRepository notesRepository,
            UserRepository userRepository,
            LabelRepository labelRepository,
            ExportEventPublisher exportEventPublisher,
            NotesCacheService notesCacheService,
            NoteJmsPublisher noteJmsPublisher) {

        this.notesRepository = notesRepository;
        this.userRepository = userRepository;
        this.labelRepository = labelRepository;
        this.exportEventPublisher = exportEventPublisher;
        this.notesCacheService = notesCacheService;
        this.noteJmsPublisher = noteJmsPublisher;
    }

    // =========================================================
    // GET USER
    // =========================================================

    private User getUser(String email) {

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"
                        ));
    }

    // =========================================================
    // CREATE NOTE
    // =========================================================

    @Override
    @Transactional
    public NotesResponse createNote(
            NotesRequest request,
            String email) {

        log.info(
                "Creating note for user: {}",
                email
        );

        User user = getUser(email);

        Notes note = new Notes();

        note.setTitle(
                request.getTitle()
        );

        note.setDescription(
                request.getDescription()
        );

        note.setUser(user);

        note.setPinned(false);
        note.setArchived(false);
        note.setTrashed(false);

        Set<Label> labels =
                getLabelsForUser(
                        request.getLabels(),
                        user
                );

        note.setLabels(labels);

        // Save note to MySQL
        Notes savedNote =
                notesRepository.save(note);

        /*
         * JMS EVENT
         *
         * The savedNote is NOT being replaced.
         * We use it to get the generated note ID.
         */
        noteJmsPublisher.publish(
                "NOTE_CREATED",
                savedNote.getNoteId(),
                email,
                "A new note was created"
        );

        NotesResponse response =
                convertToResponse(savedNote);

        /*
         * Database has changed.
         * Existing Redis data is now stale.
         */
        clearUserCache(email);

        log.info(
                "Note created successfully. ID: {}",
                savedNote.getNoteId()
        );

        return response;
    }

    // =========================================================
    // GET ALL NOTES
    // =========================================================

    @Override
    public List<NotesResponse> getAllNotes(
            String email) {

        String cacheKey =
                notesCacheService.allKey(email);

        /*
         * Check Redis first.
         */
        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {

            log.info(
                    "Redis CACHE HIT - getAllNotes: {}",
                    email
            );

            return cached;
        }

        log.info(
                "Redis CACHE MISS - getAllNotes: {}",
                email
        );

        User user = getUser(email);

        /*
         * Redis MISS -> fetch from MySQL.
         */
        List<NotesResponse> result =
                notesRepository
                        .findAllByUser(user)
                        .stream()
                        .filter(note ->
                                !note.isTrashed()
                        )
                        .map(this::convertToResponse)
                        .toList();

        /*
         * Store result in Redis.
         */
        notesCacheService.putList(
                cacheKey,
                result
        );

        return result;
    }

    // =========================================================
    // GET ONE NOTE
    // =========================================================

    @Override
    public NotesResponse getNoteById(
            int noteId,
            String email) {

        String cacheKey =
                notesCacheService.noteKey(
                        email,
                        noteId
                );

        /*
         * Check Redis first.
         */
        NotesResponse cached =
                notesCacheService.getNote(
                        cacheKey
                );

        if (cached != null) {

            log.info(
                    "Redis CACHE HIT - note {}",
                    noteId
            );

            return cached;
        }

        log.info(
                "Redis CACHE MISS - note {}",
                noteId
        );

        User user = getUser(email);

        Notes note =
                notesRepository
                        .findByNoteIdAndUser(
                                noteId,
                                user
                        )
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Note not found"
                                ));

        NotesResponse response =
                convertToResponse(note);

        notesCacheService.putNote(
                cacheKey,
                response
        );

        return response;
    }

    // =========================================================
    // UPDATE NOTE
    // =========================================================

    @Override
    @Transactional
    public NotesResponse updateNote(
            int noteId,
            NotesRequest request,
            String email) {

        log.info(
                "Updating note {} for user: {}",
                noteId,
                email
        );

        User user = getUser(email);

        Notes note =
                notesRepository
                        .findByNoteIdAndUser(
                                noteId,
                                user
                        )
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Note not found"
                                ));

        note.setTitle(
                request.getTitle()
        );

        note.setDescription(
                request.getDescription()
        );

        if (request.getLabels() != null) {

            Set<Label> labels =
                    getLabelsForUser(
                            request.getLabels(),
                            user
                    );

            note.setLabels(labels);
        }

        Notes updatedNote =
                notesRepository.save(note);

        /*
         * JMS EVENT
         */
        noteJmsPublisher.publish(
                "NOTE_UPDATED",
                updatedNote.getNoteId(),
                email,
                "Note was updated"
        );

        NotesResponse response =
                convertToResponse(updatedNote);

        /*
         * Invalidate Redis because database changed.
         */
        clearUserCache(email);

        log.info(
                "Note {} updated successfully",
                noteId
        );

        return response;
    }

    // =========================================================
    // PIN / UNPIN
    // =========================================================

    @Override
    @Transactional
    public NotesResponse togglePin(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note =
                getNote(
                        noteId,
                        user
                );

        if (note.isTrashed()) {

            throw new BusinessException(
                    "Cannot pin a trashed note"
            );
        }

        note.setPinned(
                !note.isPinned()
        );

        Notes updatedNote =
                notesRepository.save(note);

        /*
         * JMS EVENT
         */
        noteJmsPublisher.publish(
                updatedNote.isPinned()
                        ? "NOTE_PINNED"
                        : "NOTE_UNPINNED",
                updatedNote.getNoteId(),
                email,
                updatedNote.isPinned()
                        ? "Note was pinned"
                        : "Note was unpinned"
        );

        clearUserCache(email);

        log.info(
                "Note {} pin status changed to {}",
                noteId,
                updatedNote.isPinned()
        );

        return convertToResponse(
                updatedNote
        );
    }

    // =========================================================
    // GET PINNED
    // =========================================================

    @Override
    public List<NotesResponse> getPinnedNotes(
            String email) {

        String cacheKey =
                notesCacheService.pinnedKey(
                        email
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {

            log.info(
                    "Redis CACHE HIT - pinned notes"
            );

            return cached;
        }

        log.info(
                "Redis CACHE MISS - pinned notes"
        );

        User user = getUser(email);

        List<NotesResponse> result =
                notesRepository
                        .findAllByUserAndPinned(
                                user,
                                true
                        )
                        .stream()
                        .filter(note ->
                                !note.isTrashed()
                        )
                        .map(this::convertToResponse)
                        .toList();

        notesCacheService.putList(
                cacheKey,
                result
        );

        return result;
    }

    // =========================================================
    // ARCHIVE / UNARCHIVE
    // =========================================================

    @Override
    @Transactional
    public NotesResponse toggleArchive(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note =
                getNote(
                        noteId,
                        user
                );

        if (note.isTrashed()) {

            throw new BusinessException(
                    "Cannot archive a trashed note"
            );
        }

        note.setArchived(
                !note.isArchived()
        );

        Notes updatedNote =
                notesRepository.save(note);

        /*
         * JMS EVENT
         */
        noteJmsPublisher.publish(
                updatedNote.isArchived()
                        ? "NOTE_ARCHIVED"
                        : "NOTE_UNARCHIVED",
                updatedNote.getNoteId(),
                email,
                updatedNote.isArchived()
                        ? "Note was archived"
                        : "Note was unarchived"
        );

        clearUserCache(email);

        log.info(
                "Note {} archive status changed to {}",
                noteId,
                updatedNote.isArchived()
        );

        return convertToResponse(
                updatedNote
        );
    }

    // =========================================================
    // GET ARCHIVED
    // =========================================================

    @Override
    public List<NotesResponse> getArchivedNotes(
            String email) {

        String cacheKey =
                notesCacheService.archivedKey(
                        email
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {

            log.info(
                    "Redis CACHE HIT - archived notes"
            );

            return cached;
        }

        log.info(
                "Redis CACHE MISS - archived notes"
        );

        User user = getUser(email);

        List<NotesResponse> result =
                notesRepository
                        .findAllByUserAndArchived(
                                user,
                                true
                        )
                        .stream()
                        .filter(note ->
                                !note.isTrashed()
                        )
                        .map(this::convertToResponse)
                        .toList();

        notesCacheService.putList(
                cacheKey,
                result
        );

        return result;
    }

    // =========================================================
    // MOVE TO TRASH
    // =========================================================

    @Override
    @Transactional
    public NotesResponse moveToTrash(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note =
                getNote(
                        noteId,
                        user
                );

        note.setTrashed(true);
        note.setPinned(false);
        note.setArchived(false);

        Notes trashedNote =
                notesRepository.save(note);

        /*
         * JMS EVENT
         */
        noteJmsPublisher.publish(
                "NOTE_TRASHED",
                trashedNote.getNoteId(),
                email,
                "Note was moved to trash"
        );

        clearUserCache(email);

        log.info(
                "Note {} moved to trash",
                noteId
        );

        return convertToResponse(
                trashedNote
        );
    }

    // =========================================================
    // RESTORE FROM TRASH
    // =========================================================

    @Override
    @Transactional
    public NotesResponse restoreNote(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note =
                getNote(
                        noteId,
                        user
                );

        if (!note.isTrashed()) {

            throw new BusinessException(
                    "Note is not in trash"
            );
        }

        note.setTrashed(false);

        Notes restoredNote =
                notesRepository.save(note);

        /*
         * JMS EVENT
         */
        noteJmsPublisher.publish(
                "NOTE_RESTORED",
                restoredNote.getNoteId(),
                email,
                "Note was restored from trash"
        );

        clearUserCache(email);

        log.info(
                "Note {} restored",
                noteId
        );

        return convertToResponse(
                restoredNote
        );
    }

    // =========================================================
    // GET TRASH
    // =========================================================

    @Override
    public List<NotesResponse> getTrashNotes(
            String email) {

        String cacheKey =
                notesCacheService.trashKey(
                        email
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {

            log.info(
                    "Redis CACHE HIT - trash"
            );

            return cached;
        }

        log.info(
                "Redis CACHE MISS - trash"
        );

        User user = getUser(email);

        List<NotesResponse> result =
                notesRepository
                        .findAllByUserAndTrashed(
                                user,
                                true
                        )
                        .stream()
                        .map(this::convertToResponse)
                        .toList();

        notesCacheService.putList(
                cacheKey,
                result
        );

        return result;
    }

    // =========================================================
    // PERMANENT DELETE
    // =========================================================

    @Override
    @Transactional
    public void permanentlyDelete(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note =
                getNote(
                        noteId,
                        user
                );

        if (!note.isTrashed()) {

            throw new BusinessException(
                    "Only trashed notes can be permanently deleted"
            );
        }

        note.getLabels().clear();

        notesRepository.save(note);

        notesRepository.delete(note);

        /*
         * JMS EVENT
         */
        noteJmsPublisher.publish(
                "NOTE_DELETED",
                noteId,
                email,
                "Note was permanently deleted"
        );

        clearUserCache(email);

        log.info(
                "Note {} permanently deleted",
                noteId
        );
    }

    // =========================================================
    // SEARCH + FILTER
    // =========================================================

    @Override
    public List<NotesResponse> searchAndFilter(
            String email,
            String keyword,
            Boolean pinned,
            Boolean archived,
            Boolean trashed,
            String label) {

        if (trashed == null) {
            trashed = false;
        }

        String cacheKey =
                notesCacheService.searchKey(
                        email,
                        keyword,
                        pinned,
                        archived,
                        trashed,
                        label
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {

            log.info(
                    "Redis CACHE HIT - search/filter"
            );

            return cached;
        }

        log.info(
                "Redis CACHE MISS - search/filter"
        );

        User user = getUser(email);

        List<NotesResponse> result =
                notesRepository
                        .searchAndFilter(
                                user,
                                keyword,
                                pinned,
                                archived,
                                trashed,
                                label
                        )
                        .stream()
                        .map(this::convertToResponse)
                        .toList();

        notesCacheService.putList(
                cacheKey,
                result
        );

        return result;
    }

    // =========================================================
    // NOTES BY LABEL
    // =========================================================

    @Override
    public List<NotesResponse> getNotesByLabel(
            int labelId,
            String email) {

        String cacheKey =
                notesCacheService.labelKey(
                        email,
                        labelId
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {

            log.info(
                    "Redis CACHE HIT - label {}",
                    labelId
            );

            return cached;
        }

        log.info(
                "Redis CACHE MISS - label {}",
                labelId
        );

        User user = getUser(email);

        labelRepository
                .findByLabelIdAndUser(
                        labelId,
                        user
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Label not found"
                        ));

        List<NotesResponse> result =
                notesRepository
                        .findAllByLabel(
                                user,
                                labelId
                        )
                        .stream()
                        .filter(note ->
                                !note.isTrashed()
                        )
                        .map(this::convertToResponse)
                        .toList();

        notesCacheService.putList(
                cacheKey,
                result
        );

        return result;
    }

    // =========================================================
    // EXPORT NOTES
    // =========================================================

    @Override
    public void requestExport(
            String email,
            String format) {

        log.info(
                "Export requested by user: {} | Format: {}",
                email,
                format
        );

        User user = getUser(email);

        if (!"CSV".equalsIgnoreCase(format)) {

            throw new BusinessException(
                    "Only CSV export is currently supported"
            );
        }

        ExportRequestEvent event =
                new ExportRequestEvent(
                        user.getUserId(),
                        format
                );

        exportEventPublisher
                .publishExportRequest(event);

        log.info(
                "Export request published successfully for user: {}",
                email
        );
    }

    // =========================================================
    // GET NOTE FROM DATABASE
    // =========================================================

    private Notes getNote(
            int noteId,
            User user) {

        return notesRepository
                .findByNoteIdAndUser(
                        noteId,
                        user
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Note not found"
                        ));
    }

    // =========================================================
    // LABELS
    // =========================================================

    private Set<Label> getLabelsForUser(
            Set<Integer> labelIds,
            User user) {

        Set<Label> labels =
                new HashSet<>();

        if (labelIds == null ||
                labelIds.isEmpty()) {

            return labels;
        }

        for (Integer labelId : labelIds) {

            Label label =
                    labelRepository
                            .findByLabelIdAndUser(
                                    labelId,
                                    user
                            )
                            .orElseThrow(() ->
                                    new ResourceNotFoundException(
                                            "Label not found: "
                                                    + labelId
                                    ));

            labels.add(label);
        }

        return labels;
    }

    // =========================================================
    // CLEAR REDIS CACHE
    // =========================================================

    private void clearUserCache(
            String email) {

        log.info(
                "Invalidating Redis cache for user: {}",
                email
        );

        notesCacheService.clearUserCache(
                email
        );
    }

    // =========================================================
    // ENTITY -> RESPONSE DTO
    // =========================================================

    private NotesResponse convertToResponse(
            Notes note) {

        NotesResponse response =
                new NotesResponse();

        response.setNoteId(
                note.getNoteId()
        );

        response.setTitle(
                note.getTitle()
        );

        response.setDescription(
                note.getDescription()
        );

        response.setPinned(
                note.isPinned()
        );

        response.setArchived(
                note.isArchived()
        );

        response.setTrashed(
                note.isTrashed()
        );

        if (note.getLabels() != null) {

            List<String> labelNames =
                    note.getLabels()
                            .stream()
                            .map(Label::getName)
                            .toList();

            response.setLabels(
                    labelNames
            );
        }

        return response;
    }
}