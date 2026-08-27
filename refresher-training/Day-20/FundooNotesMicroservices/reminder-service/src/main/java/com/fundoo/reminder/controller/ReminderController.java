package com.fundoo.reminder.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fundoo.reminder.dto.ReminderRequest;
import com.fundoo.reminder.entity.Reminder;
import com.fundoo.reminder.service.ReminderService;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(
            ReminderService reminderService) {

        this.reminderService =
                reminderService;
    }

    @PostMapping
    public ResponseEntity<Reminder> createReminder(
            @RequestBody ReminderRequest request,
            @RequestHeader("X-User-Id") int userId) {

        Reminder reminder =
                reminderService.createReminder(
                        request,
                        userId
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reminder);
    }

    @GetMapping
    public ResponseEntity<List<Reminder>> getReminders(
            @RequestHeader("X-User-Id") int userId) {

        return ResponseEntity.ok(
                reminderService.getReminders(userId)
        );
    }

    @DeleteMapping("/{reminderId}")
    public ResponseEntity<Void> deleteReminder(
            @PathVariable int reminderId,
            @RequestHeader("X-User-Id") int userId) {

        reminderService.deleteReminder(
                reminderId,
                userId
        );

        return ResponseEntity.noContent().build();
    }
}