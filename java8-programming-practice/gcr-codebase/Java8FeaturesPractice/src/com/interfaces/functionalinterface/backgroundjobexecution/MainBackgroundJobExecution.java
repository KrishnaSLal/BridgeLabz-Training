package com.interfaces.functionalinterface.backgroundjobexecution;

public class MainBackgroundJobExecution {
    public static void main(String[] args) {

        // Using functional interface with lambda
        BackgroundJob job = () -> {
            System.out.println("Background job running...");
            System.out.println("Thread: " + Thread.currentThread().getName());
        };

        // Execute asynchronously using Runnable
        
        Thread thread = new Thread(() -> job.runJob());
        thread.start();

        System.out.println("Main thread running.");
    }
}

