package com.objectmodeling.universitymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;
    private List<Student> students;
    private Professor professor;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);

        if (professor != null) {
            System.out.println("Professor: " + professor.getProfessorName());
        }

        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println(student.getStudentName());
        }
    }
}

