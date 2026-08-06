package com.student.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Course {

    private String courseName;

    private Address address;

    public Course() {
        this.courseName = "Java Full Stack";
    }

    // Setter Injection
    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    public void displayCourse() {

        System.out.println("Course Name: " + courseName);

        address.displayAddress();
    }
}