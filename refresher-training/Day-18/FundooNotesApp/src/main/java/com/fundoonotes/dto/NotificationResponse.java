package com.fundoonotes.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationResponse {

    private int notificationId;

    private int noteId;

    private String message;

    private boolean emailSent;

    private LocalDateTime createdAt;
}