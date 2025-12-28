package com.constructor.level1;

public class Course {

    // Instance variables
    String courseName;
    int duration;      // in months
    double fee;

    // Class variable (shared by all courses)
    static String instituteName = "ABC Institute";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println(
            "Course Name: " + courseName +
            ", Duration: " + duration + " months" +
            ", Fee: ₹" + fee +
            ", Institute: " + instituteName
        );
    }

    // Class method
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {

        Course c1 = new Course("Java Full Stack", 6, 45000);
        Course c2 = new Course("Data Science", 8, 60000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Update institute name for all courses
        Course.updateInstituteName("BridgeLabz");

        System.out.println("\nAfter updating institute name:\n");

        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
