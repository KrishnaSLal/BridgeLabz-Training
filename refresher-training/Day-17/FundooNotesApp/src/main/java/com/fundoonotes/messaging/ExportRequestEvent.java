package com.fundoonotes.messaging;

public class ExportRequestEvent {

    private int userId;
    private String format;

    public ExportRequestEvent() {
    }

    public ExportRequestEvent(int userId, String format) {
        this.userId = userId;
        this.format = format;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}