package com.universitycourseenrollmentsystem;

abstract class Student {
    protected int studentId;
    protected String name;
    private double gpa;

    // Without elective preference
    public Student(int id, String name) {
        this.studentId = id;
        this.name = name;
    }

    // With elective preference (Constructor Overloading)
    public Student(int id, String name, String elective) {
        this.studentId = id;
        this.name = name;
    }

    protected void calculateGPA(int totalMarks, int subjects) {
        this.gpa = (double) totalMarks / subjects;
    }

    public String getTranscript() {
        return "Student: " + name + ", GPA: " + gpa;
    }
}
