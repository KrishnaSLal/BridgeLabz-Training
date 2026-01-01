package com.inheritance.multilevelinheritance.educationalcoursehierarchy;

class OnlineCourse extends Course {

    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration,
                 String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded Course: " + isRecorded);
    }
}
