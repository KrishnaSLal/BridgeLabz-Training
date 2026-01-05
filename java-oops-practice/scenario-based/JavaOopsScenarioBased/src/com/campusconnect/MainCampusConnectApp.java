package com.campusconnect;

import java.util.Scanner;

public class MainCampusConnectApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Faculty input
        System.out.println("Enter Faculty Details:");
        System.out.print("ID: ");
        int fid = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String fname = sc.nextLine();

        System.out.print("Email: ");
        String femail = sc.nextLine();

        System.out.print("Department: ");
        String dept = sc.nextLine();

        Faculty faculty = new Faculty(fid, fname, femail, dept);

        // Course input
        System.out.print("\nEnter Course Name: ");
        String courseName = sc.nextLine();
        Course course = new Course(courseName, faculty);

        // Student input
        System.out.println("\nEnter Student Details:");
        System.out.print("ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String sname = sc.nextLine();

        System.out.print("Email: ");
        String semail = sc.nextLine();

        Student student = new Student(sid, sname, semail);

        // Enroll student
        student.enrollCourse(course);

        // Grades input
        System.out.print("\nHow many grades to enter? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            student.addGrade(sc.nextInt());
        }

        // Output
        System.out.println("\n--- Student Details ---");
        student.printDetails();

        System.out.println("\n--- Faculty Details ---");
        faculty.printDetails();

        System.out.println("\n--- Course Details ---");
        course.showCourseDetails();

        sc.close();
    }
}
