package com.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.model.Course;
import com.student.model.Student;

public class App {

    public static void main(String[] args) {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	Course course = context.getBean("course", Course.class);
    	
    	course.displayCourse();


    }
}