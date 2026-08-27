package com.fundoo.notification.dto;

import java.time.LocalDateTime;

public record NotificationResponse(

        int notificationId,

        int noteId,

        String message,

        boolean emailSent,

        LocalDateTime createdAt

) {
}