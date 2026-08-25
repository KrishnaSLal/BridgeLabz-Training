package com.fundoonotes.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReminderJmsEvent {

    private int reminderId;

    private int noteId;

    private int userId;

    private String email;

    private String message;
}