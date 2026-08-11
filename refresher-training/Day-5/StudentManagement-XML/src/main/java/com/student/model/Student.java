package com.student.model;

public class Student {

    private int studentId;
    private String studentName;
    private Course course;
    
    public Student (int studentId, String studentName, Course course) {
    	this.studentId = studentId;
    	this.studentName = studentName;
    	this.course = course;
    }
    public void displayStudent() {
    	System.out.println(studentId + ", " + studentName);
    	
    	course.displayCourse();
    }
}