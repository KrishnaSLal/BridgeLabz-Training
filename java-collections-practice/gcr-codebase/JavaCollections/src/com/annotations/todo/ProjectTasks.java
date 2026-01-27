package com.annotations.todo;

public class ProjectTasks {

    @Todo(
        task = "Implement user authentication",
        assignedTo = "Krishna",
        priority = "HIGH"
    )
    public void authentication() {
        System.out.println("Authentication module");
    }

    @Todo(
        task = "Add payment gateway integration",
        assignedTo = "Alice"
    )
    public void paymentGateway() {
        System.out.println("Payment gateway module");
    }

    @Todo(
        task = "Optimize database queries",
        assignedTo = "Bob",
        priority = "LOW"
    )
    public void databaseOptimization() {
        System.out.println("Database optimization");
    }

    public void completedFeature() {
        System.out.println("This feature is already completed.");
    }
}
