package com.fundoo.reminder.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.reminder.dto.ReminderRequest;
import com.fundoo.reminder.entity.Reminder;
import com.fundoo.reminder.repository.ReminderRepository;

@Service
public class ReminderServiceImpl
        implements ReminderService {

    private final ReminderRepository reminderRepository;

    public ReminderServiceImpl(
            ReminderRepository reminderRepository) {

        this.reminderRepository =
                reminderRepository;
    }

    @Override
    @Transactional
    public Reminder createReminder(
            ReminderRequest request,
            int userId) {

        // -----------------------------------------
        // Validate reminder time
        // -----------------------------------------

        if (request.getReminderTime() == null) {

            throw new IllegalArgumentException(
                    "Reminder time is required"
            );
        }

        if (request.getReminderTime()
                .isBefore(LocalDateTime.now())) {

            throw new IllegalArgumentException(
                    "Reminder time must be in the future"
            );
        }

        // -----------------------------------------
        // Validate note ID
        // -----------------------------------------

        if (request.getNoteId() <= 0) {

            throw new IllegalArgumentException(
                    "Invalid note ID"
            );
        }

        // -----------------------------------------
        // Validate email
        // -----------------------------------------

        if (request.getEmail() == null
                || request.getEmail().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Email is required"
            );
        }

        // -----------------------------------------
        // Validate reminder message
        // -----------------------------------------

        if (request.getMessage() == null
                || request.getMessage().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Reminder message is required"
            );
        }

        // -----------------------------------------
        // Create Reminder entity
        // -----------------------------------------

        Reminder reminder = new Reminder();

        reminder.setNoteId(
                request.getNoteId()
        );

        reminder.setUserId(
                userId
        );

        reminder.setReminderTime(
                request.getReminderTime()
        );

        reminder.setEmail(
                request.getEmail()
        );

        reminder.setMessage(
                request.getMessage()
        );

        reminder.setSent(false);

        // -----------------------------------------
        // Save reminder
        // -----------------------------------------

        return reminderRepository.save(
                reminder
        );
    }

    @Override
    public List<Reminder> getReminders(
            int userId) {

        return reminderRepository
                .findByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteReminder(
            int reminderId,
            int userId) {

        // -----------------------------------------
        // Find reminder
        // -----------------------------------------

        Reminder reminder =
                reminderRepository
                        .findById(reminderId)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Reminder not found"
                                )
                        );

        // -----------------------------------------
        // Check ownership
        // -----------------------------------------

        if (reminder.getUserId() != userId) {

            throw new IllegalArgumentException(
                    "You are not authorized to delete this reminder"
            );
        }

        // -----------------------------------------
        // Delete reminder
        // -----------------------------------------

        reminderRepository.delete(
                reminder
        );
    }
}