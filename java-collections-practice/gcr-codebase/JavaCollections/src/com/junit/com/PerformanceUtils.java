package com.junit.com;

public class PerformanceUtils {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(1000); // 3 seconds
        return "Task Completed";
    }
}
