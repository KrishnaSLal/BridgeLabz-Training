package com.fundoo.reminder.service;

import java.util.List;

import com.fundoo.reminder.dto.ReminderRequest;
import com.fundoo.reminder.entity.Reminder;

public interface ReminderService {

    Reminder createReminder(
            ReminderRequest request,
            int userId
    );

    List<Reminder> getReminders(
            int userId
    );

    void deleteReminder(
            int reminderId,
            int userId
    );
}