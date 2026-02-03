package com.chatlogparser;

public class Message {

    private String time;
    private String user;
    private String text;

    public Message(String time, String user, String text) {
        this.time = time;
        this.user = user;
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "[" + time + "] " + text;
    }
}
