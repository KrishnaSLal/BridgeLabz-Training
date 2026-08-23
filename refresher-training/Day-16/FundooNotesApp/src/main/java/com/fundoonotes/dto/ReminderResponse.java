package com.fundoonotes.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReminderResponse {

    private Integer reminderId;

    private Integer noteId;

    private LocalDateTime reminderTime;

    private String message;

    private boolean sent;
}