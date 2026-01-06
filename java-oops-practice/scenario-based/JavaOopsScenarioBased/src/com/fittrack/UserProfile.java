package com.fittrack;

public class UserProfile {

    private String name;
    private int age;
    private double weight;   // protected using encapsulation
    private String goal;

    // Constructor with default goal
    public UserProfile(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = "Stay Fit";
    }

    // Constructor with custom goal
    public UserProfile(String name, int age, double weight, String goal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = goal;
    }

    // Getter (no setter for weight → protected health data)
    public double getWeight() {
        return weight;
    }

    public String getGoal() {
        return goal;
    }

    public void displayProfile() {
        System.out.println("\n--- User Profile ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Goal: " + goal);
    }
}
