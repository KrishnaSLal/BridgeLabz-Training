package com.fundoonotes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.entity.Label;
import com.fundoonotes.service.LabelService;

@RestController
@RequestMapping("/labels")
public class LabelController {

    private final LabelService labelService;

    public LabelController(
            LabelService labelService) {

        this.labelService = labelService;
    }

    @PostMapping
    public ResponseEntity<Label> createLabel(
            @RequestBody String name,
            Authentication authentication) {

        Label label = labelService.createLabel(
                name,
                authentication.getName()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(label);
    }

    @GetMapping
    public ResponseEntity<List<Label>> getLabels(
            Authentication authentication) {

        return ResponseEntity.ok(
                labelService.getLabels(
                        authentication.getName()
                )
        );
    }

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