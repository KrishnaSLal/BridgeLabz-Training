package com.universitycourseenrollmentsystem;

class Course {
    private String courseCode;
    private String courseName;

    public Course(String code, String name) {
        this.courseCode = code;
        this.courseName = name;
    }

    public String getCourseDetails() {
        return courseCode + " - " + courseName;
    }
}
