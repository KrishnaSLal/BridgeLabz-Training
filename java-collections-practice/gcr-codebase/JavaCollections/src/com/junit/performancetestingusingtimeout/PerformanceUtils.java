package com.junit.performancetestingusingtimeout;

public class PerformanceUtils {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // 3 seconds
        return "Task Completed";
    }
}
