package com.student.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.service.StudentService;

@Component
public class Address {

    private String city = "Bangalore";
    private String state = "Karnataka";

    // Field Injection
    @Autowired
    private StudentService studentService;

    public void displayAddress() {

        System.out.println("City: " + city);
        System.out.println("State: " + state);

        studentService.showService();
    }
}