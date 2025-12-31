package com.objectmodeling.companyanddepartments;

public class Employee {

    private int empId;
    private String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + empId + ", Name: " + name);
    }
}
