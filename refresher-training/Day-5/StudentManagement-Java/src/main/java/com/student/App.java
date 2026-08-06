package com.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.student.config.AppConfig;
import com.student.model.Student;

public class App {

    public static void main(String[] args) {

        // Create Spring IoC Container
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Get Student bean
        Student student = context.getBean(Student.class);

        // Execute
        student.displayStudent();
    }
}