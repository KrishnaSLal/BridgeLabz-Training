package com.fundoonotes.service;

import java.util.List;

import com.fundoonotes.dto.NotificationResponse;
import com.fundoonotes.dto.ReminderMessage;

public interface NotificationService {

    void createNotification(
            ReminderMessage message
    );

    List<NotificationResponse> getMyNotifications(
            String userEmail
    );

    List<NotificationResponse> getUnreadNotifications(
            String userEmail
    );

    void markAsRead(
            Integer notificationId,
            String userEmail
    );
}