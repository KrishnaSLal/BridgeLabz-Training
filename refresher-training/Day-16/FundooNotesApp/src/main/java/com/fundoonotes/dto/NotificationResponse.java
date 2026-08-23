package com.fundoonotes.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {

    private Integer notificationId;

    private Integer noteId;

    private String message;

    private LocalDateTime createdAt;

    private boolean readStatus;
}