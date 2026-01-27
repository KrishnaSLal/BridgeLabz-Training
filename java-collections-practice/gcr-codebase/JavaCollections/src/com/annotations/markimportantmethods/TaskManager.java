package com.annotations.markimportantmethods;

public class TaskManager {

    @ImportantMethod
    public void deployApplication() {
        System.out.println("Deploying application...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void runTests() {
        System.out.println("Running tests...");
    }

    public void normalMethod() {
        System.out.println("Just a normal method.");
    }
}
