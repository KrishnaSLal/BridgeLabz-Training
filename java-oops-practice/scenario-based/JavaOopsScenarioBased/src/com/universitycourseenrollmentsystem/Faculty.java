package com.universitycourseenrollmentsystem;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void assignGrade(Student student, int totalMarks, int subjects) {
        student.calculateGPA(totalMarks, subjects);
    }
}
