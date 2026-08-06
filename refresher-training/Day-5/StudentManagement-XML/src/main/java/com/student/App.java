package com.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.model.Student;

public class App {

    public static void main(String[] args) {

        // Create Spring IoC Container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get Student bean from Spring container
        Student student = context.getBean("student", Student.class);

        // Execute
        student.displayStudent();
    }
}