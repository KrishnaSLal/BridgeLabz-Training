package com.inheritance.hierarchialinheritance.schoolsystem;

public class MainSchool {

    public static void main(String[] args) {

        Person p1 = new Teacher("Mrs. Sharma", 40, "Mathematics");
        Person p2 = new Student("Amit", 15, "10th Grade");
        Person p3 = new Staff("Ramesh", 45, "Administration");

        p1.displayRole();
        p1.displayDetails();
        System.out.println();

        p2.displayRole();
        p2.displayDetails();
        System.out.println();

        p3.displayRole();
        p3.displayDetails();
    }
}
