package com.student.model;

public class Student {

    private int studentId;
    private String studentName;

    private Course course;

    // Constructor Injection
    public Student(Course course) {
        this.course = course;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void displayStudent() {

        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);

        course.displayCourse();
    }
}