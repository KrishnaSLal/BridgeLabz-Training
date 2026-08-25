package com.fundoonotes.service;

import java.util.List;

import com.fundoonotes.dto.NotificationResponse;
import com.fundoonotes.messaging.ReminderJmsEvent;

public interface NotificationService {

    void processReminder(
            ReminderJmsEvent event
    );

    List<NotificationResponse> getMyNotifications(
            String email
    );
}