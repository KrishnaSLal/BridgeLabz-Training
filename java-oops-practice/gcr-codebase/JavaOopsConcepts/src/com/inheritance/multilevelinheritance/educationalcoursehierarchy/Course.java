package com.inheritance.multilevelinheritance.educationalcoursehierarchy;

class Course {

    String courseName;
    int duration; // in hours

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}
