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
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.dto.LabelRequest;
import com.fundoonotes.dto.NotesResponse;
import com.fundoonotes.entity.Label;
import com.fundoonotes.service.LabelService;
import com.fundoonotes.service.NotesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/labels")
public class LabelController {

    private final LabelService labelService;

    private final NotesService notesService;

    public LabelController(
            LabelService labelService,
            NotesService notesService) {

        this.labelService = labelService;

        this.notesService = notesService;
    }

    // =========================================================
    // CREATE LABEL
    // =========================================================

    @PostMapping
    public ResponseEntity<Label> createLabel(
            @Valid @RequestBody LabelRequest request,
            Authentication authentication) {

        Label label =
                labelService.createLabel(
                        request,
                        authentication.getName()
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(label);
    }

    // =========================================================
    // GET ALL LABELS
    // =========================================================

    @GetMapping
    public ResponseEntity<List<Label>> getAllLabels(
            Authentication authentication) {

        return ResponseEntity.ok(
                labelService.getAllLabels(
                        authentication.getName()
                )
        );
    }

    // =========================================================
    // UPDATE LABEL
    // =========================================================

    @PutMapping("/{labelId}")
    public ResponseEntity<Label> updateLabel(
            @PathVariable int labelId,
            @Valid @RequestBody LabelRequest request,
            Authentication authentication) {

        Label label =
                labelService.updateLabel(
                        labelId,
                        request,
                        authentication.getName()
                );

        return ResponseEntity.ok(label);
    }

    // =========================================================
    // GET NOTES BY LABEL
    // =========================================================

    @GetMapping("/{labelId}/notes")
    public ResponseEntity<List<NotesResponse>>
            getNotesByLabel(
                    @PathVariable int labelId,
                    Authentication authentication) {

        return ResponseEntity.ok(
                notesService.getNotesByLabel(
                        labelId,
                        authentication.getName()
                )
        );
    }

    // =========================================================
    // DELETE LABEL
    // =========================================================

    @DeleteMapping("/{labelId}")
    public ResponseEntity<Void> deleteLabel(
            @PathVariable int labelId,
            Authentication authentication) {

        labelService.deleteLabel(
                labelId,
                authentication.getName()
        );

        return ResponseEntity
                .noContent()
                .build();
    }
}