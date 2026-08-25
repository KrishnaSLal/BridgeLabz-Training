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

import com.fundoonotes.dto.ReminderRequest;
import com.fundoonotes.dto.ReminderResponse;
import com.fundoonotes.service.ReminderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(
            ReminderService reminderService) {

        this.reminderService = reminderService;
    }

    @PostMapping
    public ResponseEntity<ReminderResponse>
    createReminder(
            Authentication authentication,
            @Valid @RequestBody ReminderRequest request) {

        String email =
                authentication.getName();

        ReminderResponse response =
                reminderService.createReminder(
                        email,
                        request
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ReminderResponse>>
    getMyReminders(
            Authentication authentication) {

        String email =
                authentication.getName();

        return ResponseEntity.ok(
                reminderService.getMyReminders(email)
        );
    }

    @DeleteMapping("/{reminderId}")
    public ResponseEntity<String>
    deleteReminder(
            Authentication authentication,
            @PathVariable int reminderId) {

        String email =
                authentication.getName();

        reminderService.deleteReminder(
                email,
                reminderId
        );

        return ResponseEntity.ok(
                "Reminder deleted successfully"
        );
    }
}