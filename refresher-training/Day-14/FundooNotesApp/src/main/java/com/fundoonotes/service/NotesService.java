package com.fundoonotes.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.fundoonotes.dto.NotesRequest;
import com.fundoonotes.dto.NotesResponse;
import com.fundoonotes.entity.Notes;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.NotesRepository;
import com.fundoonotes.repository.UserRepository;

@Service
public class NotesService {

    private final NotesRepository notesRepository;
    private final UserRepository userRepository;

    public NotesService(
            NotesRepository notesRepository,
            UserRepository userRepository) {

        this.notesRepository = notesRepository;
        this.userRepository = userRepository;
    }

    public NotesResponse createNote(
            NotesRequest request,
            String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"
                        ));

        Notes note = new Notes();

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setUser(user);

        LocalDateTime now = LocalDateTime.now();

        note.setCreatedAt(now);
        note.setUpdatedAt(now);

        Notes savedNote =
                notesRepository.save(note);

        return convertToResponse(savedNote);
    }

    public void deleteNote(
            int noteId,
            String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"
                        ));

        Notes note = notesRepository
                .findByNoteIdAndUser(noteId, user)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Note not found or you are not authorized to delete this note"
                        ));

        notesRepository.delete(note);
    }

    private NotesResponse convertToResponse(
            Notes note) {

        return new NotesResponse(
                note.getNoteId(),
                note.getTitle(),
                note.getDescription(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
    }
}