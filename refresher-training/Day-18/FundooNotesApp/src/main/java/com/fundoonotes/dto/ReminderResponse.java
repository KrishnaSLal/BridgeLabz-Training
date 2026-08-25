package com.fundoonotes.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReminderResponse {

    private int reminderId;

    private int noteId;

    private LocalDateTime reminderTime;

    private String message;

    private boolean triggered;
}