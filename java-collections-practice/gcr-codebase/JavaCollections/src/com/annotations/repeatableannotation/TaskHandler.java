package com.annotations.repeatableannotation;

public class TaskHandler {

    @BugReport(description = "Null pointer exception on line 25")
    @BugReport(description = "Incorrect output for negative input")
    public void processTask() {
        System.out.println("Processing task...");
    }
}

