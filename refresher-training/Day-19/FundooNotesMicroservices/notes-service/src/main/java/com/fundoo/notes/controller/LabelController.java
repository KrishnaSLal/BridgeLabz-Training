package com.fundoo.notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.fundoo.notes.dto.LabelRequest;
import com.fundoo.notes.dto.NotesResponse;
import com.fundoo.notes.entity.Label;
import com.fundoo.notes.security.JwtUtil;
import com.fundoo.notes.service.LabelService;
import com.fundoo.notes.service.NotesService;

@RestController
@RequestMapping("/labels")
public class LabelController {

    private final LabelService labelService;

    private final NotesService notesService;

    private final JwtUtil jwtUtil;

    public LabelController(
            LabelService labelService,
            NotesService notesService,
            JwtUtil jwtUtil) {

        this.labelService = labelService;

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

    @PostMapping
    public ResponseEntity<Label> createLabel(
            @Valid @RequestBody
            LabelRequest request,
            Authentication authentication) {

        Label label =
                labelService.createLabel(
                        request,
                        getUserId(authentication)
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(label);
    }

    @GetMapping
    public ResponseEntity<List<Label>>
    getAllLabels(
            Authentication authentication) {

        return ResponseEntity.ok(
                labelService.getAllLabels(
                        getUserId(authentication)
                )
        );
    }

    @PutMapping("/{labelId}")
    public ResponseEntity<Label>
    updateLabel(
            @PathVariable int labelId,
            @Valid @RequestBody
            LabelRequest request,
            Authentication authentication) {

        return ResponseEntity.ok(
                labelService.updateLabel(
                        labelId,
                        request,
                        getUserId(authentication)
                )
        );
    }

    @GetMapping("/{labelId}/notes")
    public ResponseEntity<List<NotesResponse>>
    getNotesByLabel(
            @PathVariable int labelId,
            Authentication authentication) {

        return ResponseEntity.ok(
                notesService.getNotesByLabel(
                        labelId,
                        getUserId(authentication)
                )
        );
    }

    @DeleteMapping("/{labelId}")
    public ResponseEntity<Void>
    deleteLabel(
            @PathVariable int labelId,
            Authentication authentication) {

        labelService.deleteLabel(
                labelId,
                getUserId(authentication)
        );

        return ResponseEntity
                .noContent()
                .build();
    }
}