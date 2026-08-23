package com.fundoonotes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoonotes.dto.ReminderRequest;
import com.fundoonotes.dto.ReminderResponse;
import com.fundoonotes.entity.Reminder;
import com.fundoonotes.repository.ReminderRepository;

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
    public ReminderResponse createReminder(
            ReminderRequest request,
            String userEmail) {

        Reminder reminder = new Reminder();

        reminder.setNoteId(request.getNoteId());
        reminder.setReminderTime(
                request.getReminderTime()
        );
        reminder.setMessage(
                request.getMessage()
        );
        reminder.setUserEmail(userEmail);
        reminder.setSent(false);

        Reminder savedReminder =
                reminderRepository.save(reminder);

        return mapToResponse(savedReminder);
    }

    @Override
    public List<ReminderResponse> getMyReminders(
            String userEmail) {

        return reminderRepository
                .findByUserEmailOrderByReminderTimeAsc(
                        userEmail
                )
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteReminder(
            Integer reminderId,
            String userEmail) {

        Reminder reminder =
                reminderRepository
                        .findById(reminderId)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Reminder not found"
                                )
                        );

        if (!reminder
                .getUserEmail()
                .equals(userEmail)) {

            throw new IllegalArgumentException(
                    "You cannot delete another user's reminder"
            );
        }

        reminderRepository.delete(reminder);
    }

    private ReminderResponse mapToResponse(
            Reminder reminder) {

        return new ReminderResponse(
                reminder.getReminderId(),
                reminder.getNoteId(),
                reminder.getReminderTime(),
                reminder.getMessage(),
                reminder.isSent()
        );
    }
}