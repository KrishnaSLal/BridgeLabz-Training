package com.fundoonotes.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoonotes.dto.NotesRequest;
import com.fundoonotes.dto.NotesResponse;
import com.fundoonotes.entity.Label;
import com.fundoonotes.entity.Notes;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.LabelRepository;
import com.fundoonotes.repository.NotesRepository;
import com.fundoonotes.repository.UserRepository;

@Service
public class NotesServiceImpl implements NotesService {

    private final NotesRepository notesRepository;

    private final UserRepository userRepository;

    private final LabelRepository labelRepository;

    public NotesServiceImpl(
            NotesRepository notesRepository,
            UserRepository userRepository,
            LabelRepository labelRepository) {

        this.notesRepository = notesRepository;
        this.userRepository = userRepository;
        this.labelRepository = labelRepository;
    }

    // =========================================================
    // GET USER
    // =========================================================

    private User getUser(String email) {

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
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

        User user = getUser(email);

        Notes note = new Notes();

        note.setTitle(request.getTitle());

        note.setDescription(
                request.getDescription()
        );

        note.setUser(user);

        note.setPinned(false);
        note.setArchived(false);
        note.setTrashed(false);

        // Assign labels
        Set<Label> labels =
                getLabelsForUser(
                        request.getLabels(),
                        user
                );

        note.setLabels(labels);

        Notes savedNote =
                notesRepository.save(note);

        return convertToResponse(savedNote);
    }

    // =========================================================
    // GET ALL NOTES
    // =========================================================

    @Override
    public List<NotesResponse> getAllNotes(
            String email) {

        User user = getUser(email);

        List<Notes> notes =
                notesRepository.findAllByUser(user);

        /*
         * Normal notes screen:
         * don't show trash notes.
         */
        return notes.stream()
                .filter(note -> !note.isTrashed())
                .map(this::convertToResponse)
                .toList();
    }

    // =========================================================
    // GET ONE NOTE
    // =========================================================

    @Override
    public NotesResponse getNoteById(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note =
                notesRepository
                        .findByNoteIdAndUser(
                                noteId,
                                user
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Note not found"
                                ));

        return convertToResponse(note);
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

        User user = getUser(email);

        Notes note =
                notesRepository
                        .findByNoteIdAndUser(
                                noteId,
                                user
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Note not found"
                                ));

        note.setTitle(request.getTitle());

        note.setDescription(
                request.getDescription()
        );

        /*
         * Update labels only if supplied.
         */
        if (request.getLabels() != null) {

            Set<Label> labels =
                    getLabelsForUser(
                            request.getLabels(),
                            user
                    );

            note.setLabels(labels);
        }

        return convertToResponse(
                notesRepository.save(note)
        );
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
                getNote(noteId, user);

        /*
         * A trashed note should not be pinned.
         */
        if (note.isTrashed()) {
            throw new RuntimeException(
                    "Cannot pin a trashed note"
            );
        }

        note.setPinned(
                !note.isPinned()
        );

        return convertToResponse(
                notesRepository.save(note)
        );
    }

    // =========================================================
    // GET PINNED
    // =========================================================

    @Override
    public List<NotesResponse> getPinnedNotes(
            String email) {

        User user = getUser(email);

        return notesRepository
                .findAllByUserAndPinned(
                        user,
                        true
                )
                .stream()
                .filter(note -> !note.isTrashed())
                .map(this::convertToResponse)
                .toList();
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
                getNote(noteId, user);

        if (note.isTrashed()) {
            throw new RuntimeException(
                    "Cannot archive a trashed note"
            );
        }

        note.setArchived(
                !note.isArchived()
        );

        return convertToResponse(
                notesRepository.save(note)
        );
    }

    // =========================================================
    // GET ARCHIVED
    // =========================================================

    @Override
    public List<NotesResponse> getArchivedNotes(
            String email) {

        User user = getUser(email);

        return notesRepository
                .findAllByUserAndArchived(
                        user,
                        true
                )
                .stream()
                .filter(note -> !note.isTrashed())
                .map(this::convertToResponse)
                .toList();
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
                getNote(noteId, user);

        note.setTrashed(true);

        /*
         * A trashed note should not remain
         * pinned or archived.
         */
        note.setPinned(false);
        note.setArchived(false);

        return convertToResponse(
                notesRepository.save(note)
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
                getNote(noteId, user);

        if (!note.isTrashed()) {
            throw new RuntimeException(
                    "Note is not in trash"
            );
        }

        note.setTrashed(false);

        return convertToResponse(
                notesRepository.save(note)
        );
    }

    // =========================================================
    // GET TRASH
    // =========================================================

    @Override
    public List<NotesResponse> getTrashNotes(
            String email) {

        User user = getUser(email);

        return notesRepository
                .findAllByUserAndTrashed(
                        user,
                        true
                )
                .stream()
                .map(this::convertToResponse)
                .toList();
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
                getNote(noteId, user);

        if (!note.isTrashed()) {
            throw new RuntimeException(
                    "Only trashed notes can be permanently deleted"
            );
        }

        /*
         * Remove label relationship first.
         */
        note.getLabels().clear();

        notesRepository.save(note);

        notesRepository.delete(note);
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

        User user = getUser(email);

        /*
         * If the caller doesn't specify trash state,
         * normal search should exclude trash.
         */
        if (trashed == null) {
            trashed = false;
        }

        List<Notes> notes =
                notesRepository.searchAndFilter(
                        user,
                        keyword,
                        pinned,
                        archived,
                        trashed,
                        label
                );

        return notes.stream()
                .map(this::convertToResponse)
                .toList();
    }

    // =========================================================
    // NOTES BY LABEL
    // =========================================================

    @Override
    public List<NotesResponse> getNotesByLabel(
            int labelId,
            String email) {

        User user = getUser(email);

        /*
         * First verify that label belongs
         * to this user.
         */
        labelRepository
                .findByLabelIdAndUser(
                        labelId,
                        user
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Label not found"
                        ));

        return notesRepository
                .findAllByLabel(
                        user,
                        labelId
                )
                .stream()
                .filter(note -> !note.isTrashed())
                .map(this::convertToResponse)
                .toList();
    }

    // =========================================================
    // GET NOTE
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
                        new RuntimeException(
                                "Note not found"
                        ));
    }

    // =========================================================
    // GET LABELS
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
                                    new RuntimeException(
                                            "Label not found: "
                                            + labelId
                                    ));

            labels.add(label);
        }

        return labels;
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