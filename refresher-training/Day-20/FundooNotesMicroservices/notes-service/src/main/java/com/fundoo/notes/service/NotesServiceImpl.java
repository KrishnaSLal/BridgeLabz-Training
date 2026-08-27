package com.fundoo.notes.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.notes.dto.NotesRequest;
import com.fundoo.notes.dto.NotesResponse;
import com.fundoo.notes.entity.Label;
import com.fundoo.notes.entity.Notes;
import com.fundoo.notes.exception.BusinessException;
import com.fundoo.notes.exception.ResourceNotFoundException;
import com.fundoo.notes.messaging.ExportEventPublisher;
import com.fundoo.notes.messaging.ExportRequestEvent;
import com.fundoo.notes.messaging.NoteJmsPublisher;
import com.fundoo.notes.repository.LabelRepository;
import com.fundoo.notes.repository.NotesRepository;

@Service
public class NotesServiceImpl
        implements NotesService {

    private static final Logger log =
            LoggerFactory.getLogger(
                    NotesServiceImpl.class
            );

    private final NotesRepository notesRepository;

    private final LabelRepository labelRepository;

    private final NotesCacheService notesCacheService;

    private final NoteJmsPublisher noteJmsPublisher;

    private final ExportEventPublisher exportEventPublisher;

    public NotesServiceImpl(
            NotesRepository notesRepository,
            LabelRepository labelRepository,
            NotesCacheService notesCacheService,
            NoteJmsPublisher noteJmsPublisher,
            ExportEventPublisher exportEventPublisher) {

        this.notesRepository = notesRepository;

        this.labelRepository = labelRepository;

        this.notesCacheService =
                notesCacheService;

        this.noteJmsPublisher =
                noteJmsPublisher;

        this.exportEventPublisher =
                exportEventPublisher;
    }

    // =========================================================
    // CREATE
    // =========================================================

    @Override
    @Transactional
    public NotesResponse createNote(
            NotesRequest request,
            int userId) {

        log.info(
                "Creating note for user: {}",
                userId
        );

        Notes note = new Notes();

        note.setTitle(
                request.getTitle()
        );

        note.setDescription(
                request.getDescription()
        );

        note.setUserId(userId);

        note.setPinned(false);

        note.setArchived(false);

        note.setTrashed(false);

        note.setLabels(
                getLabelsForUser(
                        request.getLabels(),
                        userId
                )
        );

        Notes savedNote =
                notesRepository.save(note);

        noteJmsPublisher.publish(
                "NOTE_CREATED",
                savedNote.getNoteId(),
                String.valueOf(userId),
                "A new note was created"
        );

        clearUserCache(userId);

        return convertToResponse(
                savedNote
        );
    }

    // =========================================================
    // GET ALL
    // =========================================================

    @Override
    public List<NotesResponse> getAllNotes(
            int userId) {

        String cacheKey =
                notesCacheService.allKey(
                        userId
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {

            log.info(
                    "Redis CACHE HIT - all notes"
            );

            return cached;
        }

        log.info(
                "Redis CACHE MISS - all notes"
        );

        List<NotesResponse> result =
                notesRepository
                        .findAllByUserId(userId)
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
    // GET ONE
    // =========================================================

    @Override
    public NotesResponse getNoteById(
            int noteId,
            int userId) {

        String cacheKey =
                notesCacheService.noteKey(
                        userId,
                        noteId
                );

        NotesResponse cached =
                notesCacheService.getNote(
                        cacheKey
                );

        if (cached != null) {

            return cached;
        }

        Notes note =
                getNote(
                        noteId,
                        userId
                );

        NotesResponse response =
                convertToResponse(note);

        notesCacheService.putNote(
                cacheKey,
                response
        );

        return response;
    }

    // =========================================================
    // UPDATE
    // =========================================================

    @Override
    @Transactional
    public NotesResponse updateNote(
            int noteId,
            NotesRequest request,
            int userId) {

        Notes note =
                getNote(
                        noteId,
                        userId
                );

        note.setTitle(
                request.getTitle()
        );

        note.setDescription(
                request.getDescription()
        );

        if (request.getLabels() != null) {

            note.setLabels(
                    getLabelsForUser(
                            request.getLabels(),
                            userId
                    )
            );
        }

        Notes updated =
                notesRepository.save(note);

        noteJmsPublisher.publish(
                "NOTE_UPDATED",
                updated.getNoteId(),
                String.valueOf(userId),
                "Note was updated"
        );

        clearUserCache(userId);

        return convertToResponse(updated);
    }

    // =========================================================
    // PIN
    // =========================================================

    @Override
    @Transactional
    public NotesResponse togglePin(
            int noteId,
            int userId) {

        Notes note =
                getNote(
                        noteId,
                        userId
                );

        if (note.isTrashed()) {

            throw new BusinessException(
                    "Cannot pin a trashed note"
            );
        }

        note.setPinned(
                !note.isPinned()
        );

        Notes updated =
                notesRepository.save(note);

        noteJmsPublisher.publish(
                updated.isPinned()
                        ? "NOTE_PINNED"
                        : "NOTE_UNPINNED",
                updated.getNoteId(),
                String.valueOf(userId),
                updated.isPinned()
                        ? "Note was pinned"
                        : "Note was unpinned"
        );

        clearUserCache(userId);

        return convertToResponse(updated);
    }

    // =========================================================
    // GET PINNED
    // =========================================================

    @Override
    public List<NotesResponse> getPinnedNotes(
            int userId) {

        String cacheKey =
                notesCacheService.pinnedKey(
                        userId
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {
            return cached;
        }

        List<NotesResponse> result =
                notesRepository
                        .findAllByUserIdAndPinned(
                                userId,
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
    // ARCHIVE
    // =========================================================

    @Override
    @Transactional
    public NotesResponse toggleArchive(
            int noteId,
            int userId) {

        Notes note =
                getNote(
                        noteId,
                        userId
                );

        if (note.isTrashed()) {

            throw new BusinessException(
                    "Cannot archive a trashed note"
            );
        }

        note.setArchived(
                !note.isArchived()
        );

        Notes updated =
                notesRepository.save(note);

        noteJmsPublisher.publish(
                updated.isArchived()
                        ? "NOTE_ARCHIVED"
                        : "NOTE_UNARCHIVED",
                updated.getNoteId(),
                String.valueOf(userId),
                updated.isArchived()
                        ? "Note was archived"
                        : "Note was unarchived"
        );

        clearUserCache(userId);

        return convertToResponse(updated);
    }

    // =========================================================
    // GET ARCHIVED
    // =========================================================

    @Override
    public List<NotesResponse> getArchivedNotes(
            int userId) {

        String cacheKey =
                notesCacheService.archivedKey(
                        userId
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {
            return cached;
        }

        List<NotesResponse> result =
                notesRepository
                        .findAllByUserIdAndArchived(
                                userId,
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
    // TRASH
    // =========================================================

    @Override
    @Transactional
    public NotesResponse moveToTrash(
            int noteId,
            int userId) {

        Notes note =
                getNote(
                        noteId,
                        userId
                );

        note.setTrashed(true);

        note.setPinned(false);

        note.setArchived(false);

        Notes updated =
                notesRepository.save(note);

        noteJmsPublisher.publish(
                "NOTE_TRASHED",
                updated.getNoteId(),
                String.valueOf(userId),
                "Note was moved to trash"
        );

        clearUserCache(userId);

        return convertToResponse(updated);
    }

    // =========================================================
    // RESTORE
    // =========================================================

    @Override
    @Transactional
    public NotesResponse restoreNote(
            int noteId,
            int userId) {

        Notes note =
                getNote(
                        noteId,
                        userId
                );

        if (!note.isTrashed()) {

            throw new BusinessException(
                    "Note is not in trash"
            );
        }

        note.setTrashed(false);

        Notes updated =
                notesRepository.save(note);

        noteJmsPublisher.publish(
                "NOTE_RESTORED",
                updated.getNoteId(),
                String.valueOf(userId),
                "Note was restored from trash"
        );

        clearUserCache(userId);

        return convertToResponse(updated);
    }

    // =========================================================
    // GET TRASH
    // =========================================================

    @Override
    public List<NotesResponse> getTrashNotes(
            int userId) {

        String cacheKey =
                notesCacheService.trashKey(
                        userId
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {
            return cached;
        }

        List<NotesResponse> result =
                notesRepository
                        .findAllByUserIdAndTrashed(
                                userId,
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
            int userId) {

        Notes note =
                getNote(
                        noteId,
                        userId
                );

        if (!note.isTrashed()) {

            throw new BusinessException(
                    "Only trashed notes can be permanently deleted"
            );
        }

        note.getLabels().clear();

        notesRepository.save(note);

        notesRepository.delete(note);

        noteJmsPublisher.publish(
                "NOTE_DELETED",
                noteId,
                String.valueOf(userId),
                "Note was permanently deleted"
        );

        clearUserCache(userId);
    }

    // =========================================================
    // SEARCH + FILTER
    // =========================================================

    @Override
    public List<NotesResponse> searchAndFilter(
            int userId,
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
                        userId,
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
            return cached;
        }

        List<NotesResponse> result =
                notesRepository
                        .searchAndFilter(
                                userId,
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
            int userId) {

        String cacheKey =
                notesCacheService.labelKey(
                        userId,
                        labelId
                );

        List<NotesResponse> cached =
                notesCacheService.getList(
                        cacheKey
                );

        if (cached != null) {
            return cached;
        }

        labelRepository
                .findByLabelIdAndUserId(
                        labelId,
                        userId
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Label not found"
                        ));

        List<NotesResponse> result =
                notesRepository
                        .findAllByLabel(
                                userId,
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
    // EXPORT
    // =========================================================

    @Override
    public void requestExport(
            int userId,
            String format) {

        if (!"CSV".equalsIgnoreCase(format)) {

            throw new BusinessException(
                    "Only CSV export is currently supported"
            );
        }

        ExportRequestEvent event =
                new ExportRequestEvent(
                        userId,
                        format
                );

        exportEventPublisher
                .publishExportRequest(event);
    }

    // =========================================================
    // GET NOTE
    // =========================================================

    private Notes getNote(
            int noteId,
            int userId) {

        return notesRepository
                .findByNoteIdAndUserId(
                        noteId,
                        userId
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
            int userId) {

        Set<Label> labels =
                new HashSet<>();

        if (labelIds == null
                || labelIds.isEmpty()) {

            return labels;
        }

        for (Integer labelId : labelIds) {

            Label label =
                    labelRepository
                            .findByLabelIdAndUserId(
                                    labelId,
                                    userId
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
    // CACHE INVALIDATION
    // =========================================================

    private void clearUserCache(
            int userId) {

        notesCacheService
                .clearUserCache(userId);
    }

    // =========================================================
    // ENTITY -> DTO
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