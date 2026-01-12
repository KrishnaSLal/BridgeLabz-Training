package com.skillforge;

import java.util.Scanner;

public class MainSkillForge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Instructor
        System.out.print("Enter instructor name: ");
        String instructorName = sc.nextLine();
        Instructor instructor = new Instructor(instructorName);

        // Course
        System.out.print("Enter course title: ");
        String courseTitle = sc.nextLine();

        System.out.print("Enter number of modules: ");
        int moduleCount = sc.nextInt();
        sc.nextLine();

        String[] modules = new String[moduleCount];
        for (int i = 0; i < moduleCount; i++) {
            System.out.print("Enter module " + (i + 1) + ": ");
            modules[i] = sc.nextLine();
        }

        System.out.print("Enter course level (1-Beginner, 2-Advanced): ");
        int level = sc.nextInt();

        Course course;
        if (level == 1) {
            course = new BeginnerCourse(courseTitle, instructor, modules);
        } else {
            course = new AdvancedCourse(courseTitle, instructor, modules);
        }

        instructor.uploadCourse(course.getTitle());

        // Student
        sc.nextLine();
        System.out.print("\nEnter student name: ");
        String studentName = sc.nextLine();
        Student student = new Student(studentName);

        System.out.print("Enter completed modules count: ");
        int completed = sc.nextInt();

        student.updateProgress(completed, modules.length);

        System.out.println("\nProgress: " + student.getProgress() + "%");
        student.generateCertificate();

        sc.close();
    }
}
