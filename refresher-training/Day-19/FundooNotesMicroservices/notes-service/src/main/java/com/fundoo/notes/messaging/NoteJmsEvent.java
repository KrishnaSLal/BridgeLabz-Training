package com.fundoo.notes.messaging;

import java.io.Serializable;

public class NoteJmsEvent
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private String action;

    private Integer noteId;

    private String userId;

    private String message;

    public NoteJmsEvent() {
    }

    public NoteJmsEvent(
            String action,
            Integer noteId,
            String userId,
            String message) {

        this.action = action;

        this.noteId = noteId;

        this.userId = userId;

        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}