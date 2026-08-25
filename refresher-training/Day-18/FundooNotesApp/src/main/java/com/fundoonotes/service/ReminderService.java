package com.fundoonotes.service;

import java.util.List;

import com.fundoonotes.dto.ReminderRequest;
import com.fundoonotes.dto.ReminderResponse;

public interface ReminderService {

    ReminderResponse createReminder(
            String email,
            ReminderRequest request
    );

    List<ReminderResponse> getMyReminders(
            String email
    );

    void deleteReminder(
            String email,
            int reminderId
    );
}