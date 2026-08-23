package com.fundoonotes.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReminderMessage implements Serializable {

    private Integer reminderId;

    private Integer noteId;

    private String userEmail;

    private String message;

    private LocalDateTime reminderTime;
}