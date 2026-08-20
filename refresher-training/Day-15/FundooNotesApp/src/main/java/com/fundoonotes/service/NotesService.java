package com.fundoonotes.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fundoonotes.dto.NotesRequest;
import com.fundoonotes.dto.NotesResponse;
import com.fundoonotes.entity.Label;
import com.fundoonotes.entity.Notes;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.LabelRepository;
import com.fundoonotes.repository.NotesRepository;
import com.fundoonotes.repository.UserRepository;

@Service
public class NotesService {

    private final NotesRepository notesRepository;
    private final UserRepository userRepository;
    private final LabelRepository labelRepository;

    public NotesService(
            NotesRepository notesRepository,
            UserRepository userRepository,
            LabelRepository labelRepository) {

        this.notesRepository = notesRepository;
        this.userRepository = userRepository;
        this.labelRepository = labelRepository;
    }

    // =========================================================
    // CREATE
    // =========================================================

    public NotesResponse createNote(
            NotesRequest request,
            String email) {

        User user = getUser(email);

        Notes note = new Notes();

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setUser(user);

        LocalDateTime now = LocalDateTime.now();

        note.setCreatedAt(now);
        note.setUpdatedAt(now);

        // Default states
        note.setPinned(false);
        note.setArchived(false);
        note.setTrashed(false);

        // Add labels if provided
        if (request.getLabels() != null) {

            note.setLabels(
                    getOrCreateLabels(
                            request.getLabels(),
                            user
                    )
            );
        }

        Notes savedNote = notesRepository.save(note);

        return convertToResponse(savedNote);
    }


    // =========================================================
    // READ ALL
    // =========================================================

    public List<NotesResponse> getAllNotes(
            String email) {

        User user = getUser(email);

        List<Notes> notes =
                notesRepository.findAllByUser(user);

        return notes.stream()
                .map(this::convertToResponse)
                .toList();
    }


    // =========================================================
    // READ ONE
    // =========================================================

    public NotesResponse getNoteById(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note = getNote(noteId, user);

        return convertToResponse(note);
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public NotesResponse updateNote(
            int noteId,
            NotesRequest request,
            String email) {

        User user = getUser(email);

        Notes note = getNote(noteId, user);

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());

        // Update labels
        if (request.getLabels() != null) {

            note.setLabels(
                    getOrCreateLabels(
                            request.getLabels(),
                            user
                    )
            );
        }

        note.setUpdatedAt(LocalDateTime.now());

        Notes updatedNote =
                notesRepository.save(note);

        return convertToResponse(updatedNote);
    }


    // =========================================================
    // PIN / UNPIN
    // =========================================================

    public NotesResponse togglePin(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note = getNote(noteId, user);

        // true -> false
        // false -> true
        note.setPinned(!note.isPinned());

        note.setUpdatedAt(LocalDateTime.now());

        Notes updatedNote =
                notesRepository.save(note);

        return convertToResponse(updatedNote);
    }


    // =========================================================
    // ARCHIVE / UNARCHIVE
    // =========================================================

    public NotesResponse toggleArchive(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note = getNote(noteId, user);

        // true -> false
        // false -> true
        note.setArchived(!note.isArchived());

        note.setUpdatedAt(LocalDateTime.now());

        Notes updatedNote =
                notesRepository.save(note);

        return convertToResponse(updatedNote);
    }


    // =========================================================
    // MOVE TO TRASH
    // =========================================================

    public NotesResponse moveToTrash(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note = getNote(noteId, user);

        note.setTrashed(true);

        // A trashed note should not remain pinned
        note.setPinned(false);

        note.setUpdatedAt(LocalDateTime.now());

        Notes updatedNote =
                notesRepository.save(note);

        return convertToResponse(updatedNote);
    }


    // =========================================================
    // RESTORE FROM TRASH
    // =========================================================

    public NotesResponse restoreNote(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note = getNote(noteId, user);

        note.setTrashed(false);

        note.setUpdatedAt(LocalDateTime.now());

        Notes updatedNote =
                notesRepository.save(note);

        return convertToResponse(updatedNote);
    }


    // =========================================================
    // PERMANENT DELETE
    // =========================================================

    public void permanentlyDelete(
            int noteId,
            String email) {

        User user = getUser(email);

        Notes note = getNote(noteId, user);

        notesRepository.delete(note);
    }


    // =========================================================
    // GET ARCHIVED NOTES
    // =========================================================

    public List<NotesResponse> getArchivedNotes(
            String email) {

        User user = getUser(email);

        List<Notes> notes =
                notesRepository.findAllByUserAndArchived(
                        user,
                        true
                );

        return notes.stream()

                // Do not show trashed notes in archive
                .filter(note -> !note.isTrashed())

                .map(this::convertToResponse)

                .toList();
    }


    // =========================================================
    // GET TRASH NOTES
    // =========================================================

    public List<NotesResponse> getTrashNotes(
            String email) {

        User user = getUser(email);

        List<Notes> notes =
                notesRepository.findAllByUserAndTrashed(
                        user,
                        true
                );

        return notes.stream()
                .map(this::convertToResponse)
                .toList();
    }


    // =========================================================
    // SEARCH & FILTER
    // =========================================================

    public List<NotesResponse> searchAndFilter(
            String email,
            String keyword,
            Boolean pinned,
            Boolean archived,
            Boolean trashed,
            String label) {

        User user = getUser(email);

        // If keyword is not provided,
        // search using empty string.
        if (keyword == null) {
            keyword = "";
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
    // USER HELPER
    // =========================================================

    private User getUser(String email) {

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"
                        ));
    }


    // =========================================================
    // NOTE HELPER
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
                        new IllegalArgumentException(
                                "Note not found or you are not authorized to access this note"
                        ));
    }


    // =========================================================
    // LABEL HELPER
    // =========================================================

    private Set<Label> getOrCreateLabels(
            List<String> labelNames,
            User user) {

        Set<Label> labels = new HashSet<>();

        for (String name : labelNames) {

            if (name == null) {
                continue;
            }

            String trimmedName =
                    name.trim();

            // Ignore empty labels
            if (trimmedName.isEmpty()) {
                continue;
            }

            Label label =
                    labelRepository
                            .findByNameAndUser(
                                    trimmedName,
                                    user
                            )
                            .orElseGet(() -> {

                                Label newLabel =
                                        new Label();

                                newLabel.setName(
                                        trimmedName
                                );

                                newLabel.setUser(user);

                                return labelRepository.save(
                                        newLabel
                                );
                            });

            labels.add(label);
        }

        return labels;
    }


    // =========================================================
    // ENTITY -> RESPONSE DTO
    // =========================================================

    private NotesResponse convertToResponse(
            Notes note) {

        List<String> labels =
                note.getLabels()
                        .stream()
                        .map(Label::getName)
                        .toList();

        return new NotesResponse(
                note.getNoteId(),
                note.getTitle(),
                note.getDescription(),
                note.getCreatedAt(),
                note.getUpdatedAt(),
                note.isPinned(),
                note.isArchived(),
                note.isTrashed(),
                labels
        );
    }
}