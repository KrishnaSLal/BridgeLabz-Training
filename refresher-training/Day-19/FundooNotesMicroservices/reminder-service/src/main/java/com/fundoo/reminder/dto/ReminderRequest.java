package com.fundoo.reminder.dto;

import java.time.LocalDateTime;

public class ReminderRequest {

    private int noteId;

    private LocalDateTime reminderTime;
    
    private String email;
    private String message;

    public ReminderRequest() {
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(
            LocalDateTime reminderTime) {

        this.reminderTime = reminderTime;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}