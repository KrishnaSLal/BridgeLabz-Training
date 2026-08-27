package com.fundoo.reminder.messaging;

public class ReminderJmsEvent {

    private int reminderId;

    private int noteId;

    private int userId;

    private String email;

    private String message;

    public ReminderJmsEvent() {
    }

    public ReminderJmsEvent(
            int reminderId,
            int noteId,
            int userId,
            String email,
            String message) {

        this.reminderId = reminderId;
        this.noteId = noteId;
        this.userId = userId;
        this.email = email;
        this.message = message;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(
            int reminderId) {

        this.reminderId = reminderId;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public void setMessage(
            String message) {

        this.message = message;
    }

    @Override
    public String toString() {

        return "ReminderJmsEvent{" +
                "reminderId=" + reminderId +
                ", noteId=" + noteId +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}