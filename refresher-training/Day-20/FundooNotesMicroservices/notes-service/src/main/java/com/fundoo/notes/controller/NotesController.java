package com.fundoo.notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.fundoo.notes.dto.NotesRequest;
import com.fundoo.notes.dto.NotesResponse;
import com.fundoo.notes.security.JwtUtil;
import com.fundoo.notes.service.NotesService;

@RestController
@RequestMapping("/notes")
public class NotesController {

    private final NotesService notesService;

    private final JwtUtil jwtUtil;

    public NotesController(
            NotesService notesService,
            JwtUtil jwtUtil) {

        this.notesService = notesService;

        this.jwtUtil = jwtUtil;
    }

    private int getUserId(
            Authentication authentication) {

        String token =
                authentication
                        .getCredentials()
                        .toString();

        return jwtUtil.extractUserId(token);
    }

    // =========================================================
    // CREATE
    // =========================================================

    @PostMapping
    public ResponseEntity<NotesResponse> createNote(
            @Valid @RequestBody
            NotesRequest request,
            Authentication authentication) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    notesService.createNote(
                        request,
                        getUserId(authentication)
                    )
                );
    }

    // =========================================================
    // SEARCH + FILTER
    // =========================================================

    @GetMapping("/search")
    public ResponseEntity<List<NotesResponse>>
    searchAndFilter(
            @RequestParam(required = false)
            String keyword,

            @RequestParam(required = false)
            Boolean pinned,

            @RequestParam(required = false)
            Boolean archived,

            @RequestParam(required = false)
            Boolean trashed,

            @RequestParam(required = false)
            String label,

            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.searchAndFilter(
                        getUserId(authentication),
                        keyword,
                        pinned,
                        archived,
                        trashed,
                        label
                )
        );
    }

    // =========================================================
    // PINNED
    // =========================================================

    @GetMapping("/pinned")
    public ResponseEntity<List<NotesResponse>>
    getPinnedNotes(
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.getPinnedNotes(
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // ARCHIVED
    // =========================================================

    @GetMapping("/archived")
    public ResponseEntity<List<NotesResponse>>
    getArchivedNotes(
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.getArchivedNotes(
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // TRASH
    // =========================================================

    @GetMapping("/trash")
    public ResponseEntity<List<NotesResponse>>
    getTrashNotes(
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.getTrashNotes(
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // GET ALL
    // =========================================================

    @GetMapping
    public ResponseEntity<List<NotesResponse>>
    getAllNotes(
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.getAllNotes(
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // GET ONE
    // =========================================================

    @GetMapping("/{noteId}")
    public ResponseEntity<NotesResponse>
    getNoteById(
            @PathVariable int noteId,
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.getNoteById(
                        noteId,
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // PIN / UNPIN
    // =========================================================

    @PostMapping("/{noteId}/pin")
    public ResponseEntity<NotesResponse>
    togglePin(
            @PathVariable int noteId,
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.togglePin(
                        noteId,
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // ARCHIVE / UNARCHIVE
    // =========================================================

    @PostMapping("/{noteId}/archive")
    public ResponseEntity<NotesResponse>
    toggleArchive(
            @PathVariable int noteId,
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.toggleArchive(
                        noteId,
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // MOVE TO TRASH
    // =========================================================

    @PostMapping("/{noteId}/trash")
    public ResponseEntity<NotesResponse>
    moveToTrash(
            @PathVariable int noteId,
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.moveToTrash(
                        noteId,
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // RESTORE
    // =========================================================

    @PostMapping("/{noteId}/restore")
    public ResponseEntity<NotesResponse>
    restoreNote(
            @PathVariable int noteId,
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.restoreNote(
                        noteId,
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // UPDATE
    // =========================================================

    @PutMapping("/{noteId}")
    public ResponseEntity<NotesResponse>
    updateNote(
            @PathVariable int noteId,
            @Valid @RequestBody
            NotesRequest request,
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.updateNote(
                        noteId,
                        request,
                        getUserId(authentication)
                )
        );
    }

    // =========================================================
    // PERMANENT DELETE
    // =========================================================

    @DeleteMapping("/{noteId}/permanent")
    public ResponseEntity<Void>
    permanentlyDelete(
            @PathVariable int noteId,
            Authentication authentication) {

        notesService.permanentlyDelete(
                noteId,
                getUserId(authentication)
        );

        return ResponseEntity
                .noContent()
                .build();
    }

    // =========================================================
    // EXPORT
    // =========================================================

    @PostMapping("/export")
    public ResponseEntity<String> exportNotes(
            @RequestParam(defaultValue = "CSV")
            String format,
            Authentication authentication) {

        notesService.requestExport(
                getUserId(authentication),
                format
        );

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(
                    "Export request accepted. "
                    + "Your notes are being exported "
                    + "in the background."
                );
    }
}