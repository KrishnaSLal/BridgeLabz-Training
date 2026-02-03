package com.feedbackguru;

public class Feedback<T> {

    private T type;          // Product / Service
    private String message;
    private int rating;

    public Feedback(T type, String message, int rating) {
        this.type = type;
        this.message = message;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public String getMessage() {
        return message;
    }

    public T getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message + " (" + rating + "/10)";
    }
}
