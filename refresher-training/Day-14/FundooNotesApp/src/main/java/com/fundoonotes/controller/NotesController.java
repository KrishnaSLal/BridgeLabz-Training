package com.fundoonotes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.dto.NotesRequest;
import com.fundoonotes.dto.NotesResponse;
import com.fundoonotes.service.NotesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notes")
public class NotesController {

    private final NotesService notesService;

    public NotesController(
            NotesService notesService) {

        this.notesService = notesService;
    }

    @PostMapping
    public ResponseEntity<NotesResponse> createNote(
            @Valid @RequestBody NotesRequest request,
            Authentication authentication) {

        String email =
                authentication.getName();

        NotesResponse response =
                notesService.createNote(
                        request,
                        email
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(
            @PathVariable int noteId,
            Authentication authentication) {

        String email =
                authentication.getName();

        notesService.deleteNote(
                noteId,
                email
        );

        return ResponseEntity
                .noContent()
                .build();
    }
}