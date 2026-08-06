package com.student.model;

public class Course {

    private String courseName;
    private Address address;

    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    // Setter Injection
    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void displayCourse() {

        System.out.println("Course Name: " + courseName);

        address.displayAddress();
    }
}