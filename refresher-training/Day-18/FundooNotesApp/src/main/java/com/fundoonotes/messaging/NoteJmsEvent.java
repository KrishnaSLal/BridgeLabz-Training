package com.fundoonotes.messaging;

import java.io.Serializable;

public class NoteJmsEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String action;
    private Integer noteId;
    private String email;
    private String message;

    public NoteJmsEvent() {
    }

    public NoteJmsEvent(
            String action,
            Integer noteId,
            String email,
            String message) {

        this.action = action;
        this.noteId = noteId;
        this.email = email;
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
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

    @Override
    public String toString() {

        return "NoteJmsEvent{" +
                "action='" + action + '\'' +
                ", noteId=" + noteId +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}