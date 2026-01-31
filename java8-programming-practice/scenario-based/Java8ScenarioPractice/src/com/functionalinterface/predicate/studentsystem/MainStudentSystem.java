//In a student system, use a Predicate to check if a student is eligible for exam (attendance ≥ 75%).

package com.functionalinterface.predicate.studentsystem;

import java.util.function.Predicate;
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

        Predicate<Student> eligibility = s -> s.attendance >= 75;

        if (eligibility.test(student)) {
            System.out.println("Eligible for exam");
        } else {
            System.out.println("Not eligible for exam");
        }

        sc.close();
    }
}