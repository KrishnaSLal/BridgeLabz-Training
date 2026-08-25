package com.fundoonotes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoonotes.dto.ReminderRequest;
import com.fundoonotes.dto.ReminderResponse;
import com.fundoonotes.entity.Notes;
import com.fundoonotes.entity.Reminder;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.NotesRepository;
import com.fundoonotes.repository.ReminderRepository;
import com.fundoonotes.repository.UserRepository;

@Service
public class ReminderServiceImpl
        implements ReminderService {

    private final ReminderRepository reminderRepository;

    private final UserRepository userRepository;

    private final NotesRepository notesRepository;

    public ReminderServiceImpl(
            ReminderRepository reminderRepository,
            UserRepository userRepository,
            NotesRepository notesRepository) {

        this.reminderRepository = reminderRepository;
        this.userRepository = userRepository;
        this.notesRepository = notesRepository;
    }

    @Override
    public ReminderResponse createReminder(
            String email,
            ReminderRequest request) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "User not found"
                                )
                        );

        /*
         * Make sure the note belongs to
         * the currently logged-in user.
         */
        Notes note =
                notesRepository
                        .findByNoteIdAndUser(
                                request.getNoteId(),
                                user
                        )
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Note not found"
                                )
                        );

        Reminder reminder =
                new Reminder();

        reminder.setNoteId(
                note.getNoteId()
        );

        reminder.setUserId(
                user.getUserId()
        );

        reminder.setEmail(
                user.getEmail()
        );

        reminder.setReminderTime(
                request.getReminderTime()
        );

        reminder.setMessage(
                request.getMessage()
        );

        reminder.setTriggered(false);

        Reminder saved =
                reminderRepository.save(reminder);

        return convertToResponse(saved);
    }

    @Override
    public List<ReminderResponse> getMyReminders(
            String email) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "User not found"
                                )
                        );

        return reminderRepository
                .findByUserIdOrderByReminderTimeAsc(
                        user.getUserId()
                )
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public void deleteReminder(
            String email,
            int reminderId) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "User not found"
                                )
                        );

        Reminder reminder =
                reminderRepository
                        .findById(reminderId)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Reminder not found"
                                )
                        );

        /*
         * Important:
         * A user can delete only their own reminder.
         */
        if (reminder.getUserId()
                != user.getUserId()) {

            throw new IllegalArgumentException(
                    "You cannot delete this reminder"
            );
        }

        reminderRepository.delete(reminder);
    }

    private ReminderResponse convertToResponse(
            Reminder reminder) {

        return new ReminderResponse(
                reminder.getReminderId(),
                reminder.getNoteId(),
                reminder.getReminderTime(),
                reminder.getMessage(),
                reminder.isTriggered()
        );
    }
}