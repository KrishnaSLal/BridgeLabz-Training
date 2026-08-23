package com.fundoonotes.service;

import java.util.List;

import com.fundoonotes.dto.ReminderRequest;
import com.fundoonotes.dto.ReminderResponse;

public interface ReminderService {

    ReminderResponse createReminder(
            ReminderRequest request,
            String userEmail
    );

    List<ReminderResponse> getMyReminders(
            String userEmail
    );

    void deleteReminder(
            Integer reminderId,
            String userEmail
    );
}