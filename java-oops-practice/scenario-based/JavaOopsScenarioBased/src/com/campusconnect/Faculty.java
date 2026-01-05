package com.campusconnect;

public class Faculty extends Person {

    private String department;

    public Faculty(int id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }

    // Polymorphism
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Role: Faculty");
        System.out.println("Department: " + department);
    }
}
