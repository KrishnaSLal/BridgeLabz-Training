package com.annotations.customannotation;

public class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Krishna")
    public void completeTask() {
        System.out.println("Task completed successfully!");
    }

    @TaskInfo(priority = "Medium", assignedTo = "Alice")
    public void reviewTask() {
        System.out.println("Task reviewed successfully!");
    }
}
