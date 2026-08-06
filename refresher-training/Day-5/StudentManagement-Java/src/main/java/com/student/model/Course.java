package com.student.model;

public class Course {

    private String courseName;

    private Address address;

    public Course() {
        this.courseName = "Java Full Stack";
    }

    // Setter Injection
    public void setAddress(Address address) {
        this.address = address;
    }

    public void displayCourse() {

        System.out.println("Course Name: " + courseName);

        address.displayAddress();
    }
}