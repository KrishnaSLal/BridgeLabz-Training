package com.student.config;

import java.lang.reflect.Field;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.student.model.Address;
import com.student.model.Course;
import com.student.model.Student;
import com.student.service.StudentService;

@Configuration
public class AppConfig {

    @Bean
    public StudentService studentService() {

        return new StudentService();
    }

    @Bean
    public Address address(StudentService studentService) {

        Address address = new Address();

        try {

            Field field = Address.class
                    .getDeclaredField("studentService");

            field.setAccessible(true);

            field.set(address, studentService);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return address;
    }

    // Setter Injection
    @Bean
    public Course course(Address address) {

        Course course = new Course();

        course.setAddress(address);

        return course;
    }

    // Constructor Injection
    @Bean
    public Student student(Course course) {

        Student student = new Student(course);

        student.setStudentId(101);
        student.setStudentName("Krishna");

        return student;
    }
}