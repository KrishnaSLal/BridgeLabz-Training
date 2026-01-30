package com.functionalinterface.predicate.studentsystem;

import java.util.Scanner;

class Student {
    String name;
    double attendance;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
    }
}

public class MainStudentSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter attendance percentage: ");
        double attendance = sc.nextDouble();

        Student student = new Student(name, attendance);

        ExamEligibility eligibility =s -> s.attendance >= 75;

        if (eligibility.check(student)) {
            System.out.println("Eligible for exam");
        } else {
            System.out.println("Not eligible for exam");
        }

        sc.close();
    }
}

