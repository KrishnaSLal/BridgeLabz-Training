package com.inheritance.hierarchialinheritance.schoolsystem;

class Staff extends Person {

    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Staff Member");
    }
}
