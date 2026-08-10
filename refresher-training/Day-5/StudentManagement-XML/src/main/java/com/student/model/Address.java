package com.student.model;

import org.springframework.beans.factory.annotation.Autowired;
import com.student.service.StudentService;

public class Address {

    private String city;
    private String state;

    //Field injection
    @Autowired
    private StudentService studentService;

    public Address() {
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void displayAddress() {

        System.out.println("City: " + city);
        System.out.println("State: " + state);

        studentService.showService();
    }
}