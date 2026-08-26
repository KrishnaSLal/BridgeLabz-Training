package com.fundoonotes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import com.fundoonotes.dto.NotesRequest;
import com.fundoonotes.dto.NotesResponse;
import com.fundoonotes.service.NotesService;
import com.fundoonotes.messaging.ExportEventPublisher;
import com.fundoonotes.messaging.ExportRequestEvent;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.UserRepository;
import com.fundoonotes.service.NoteExportService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notes")
public class NotesController {

    private final NotesService notesService;
    private final UserRepository userRepository;
    private final NoteExportService noteExportService;
    
    public NotesController(
            NotesService notesService,
            UserRepository userRepository,
            NoteExportService noteExportService) {

        this.notesService = notesService;
        this.userRepository = userRepository;
        this.noteExportService = noteExportService;
    }


    // =========================================================
    // CREATE
    // =========================================================

    @PostMapping
    public ResponseEntity<NotesResponse> createNote(
            @Valid @RequestBody NotesRequest request,
            Authentication authentication) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        notesService.createNote(
                                request,
                                authentication.getName()
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
                        authentication.getName(),
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
                        authentication.getName()
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
                        authentication.getName()
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
                        authentication.getName()
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
                        authentication.getName()
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
                        authentication.getName()
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
                        authentication.getName()
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
                        authentication.getName()
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
                        authentication.getName()
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
                        authentication.getName()
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
                    @Valid @RequestBody NotesRequest request,
                    Authentication authentication) {

        return ResponseEntity.ok(
                notesService.updateNote(
                        noteId,
                        request,
                        authentication.getName()
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
                authentication.getName()
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
             authentication.getName(),
             format
     );

     return ResponseEntity
             .status(HttpStatus.ACCEPTED)
             .body(
                     "Export request accepted. "
                     + "Your notes are being exported in the background."
             );
 }
 
 @GetMapping("/exported")
 public ResponseEntity<Resource> getExportedFile(
         Authentication authentication) throws IOException {

     String email = authentication.getName();

     User user = userRepository.findByEmail(email)
             .orElseThrow(() ->
                     new RuntimeException("User not found"));

     Resource resource =
             noteExportService.getExportedFile(user.getUserId());

     if (resource == null) {
         return ResponseEntity.notFound().build();
     }

     return ResponseEntity.ok()
             .contentType(MediaType.parseMediaType("text/csv"))
             .header(
                     HttpHeaders.CONTENT_DISPOSITION,
                     "attachment; filename=\"" +
                     resource.getFilename() + "\""
             )
             .body(resource);
 }
}