package com.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.student.model.Student;

public class App {

    public static void main(String[] args) {

        // Create Spring IoC Container
        ApplicationContext context = new AnnotationConfigApplicationContext("com.student");

        // Get Student bean
        Student student = context.getBean(Student.class);

        // Set student details
        student.setStudentId(101);
        student.setStudentName("Krishna");

        // Execute
        student.displayStudent();
    }
}