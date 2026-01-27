package com.annotations.methodexecutiontime;

public class PerformanceService {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1_000; i++) {
            // fast task
        }
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 10_000_000; i++) {
            // slow task
        }
    }

    public void normalMethod() {
        System.out.println("Normal method (not logged)");
    }
}
