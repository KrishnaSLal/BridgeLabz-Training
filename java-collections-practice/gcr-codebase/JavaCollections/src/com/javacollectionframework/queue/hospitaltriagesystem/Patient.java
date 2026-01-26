package com.javacollectionframework.queue.hospitaltriagesystem;

public class Patient {

    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return name + " (Severity " + severity + ")";
    }
}
