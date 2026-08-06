package com.student.model;

import com.student.service.StudentService;

public class Address {

    private String city = "Bangalore";
    private String state = "Karnataka";

    private StudentService studentService;

    public void displayAddress() {

        System.out.println("City: " + city);
        System.out.println("State: " + state);

        studentService.showService();
    }
}