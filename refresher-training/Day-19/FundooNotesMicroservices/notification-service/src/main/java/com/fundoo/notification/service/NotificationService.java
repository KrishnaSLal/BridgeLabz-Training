package com.fundoo.notification.service;

import java.util.List;

import com.fundoo.notification.dto.NotificationResponse;
import com.fundoo.notification.messaging.ReminderJmsEvent;

public interface NotificationService {

    void processReminder(
            ReminderJmsEvent event
    );

    List<NotificationResponse>
    getMyNotifications(
            String email
    );
}