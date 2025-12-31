package com.objectmodeling.universitymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String studentName;
    private List<Course> courses;

    public Student(String studentName) {
        this.studentName = studentName;
        this.courses = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(studentName + " enrolled in " + course.getCourseName());
    }

    public void showCourses() {
        System.out.println("Courses enrolled by " + studentName + ":");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }
}