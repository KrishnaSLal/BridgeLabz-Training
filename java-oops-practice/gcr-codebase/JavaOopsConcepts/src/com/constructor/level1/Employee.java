package com.constructor.level1;

// Parent class
public class Employee {

    // Access modifiers
    public int employeeID;          // public
    protected String department;    // protected
    private double salary;          // private

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void updateSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        } else {
            System.out.println("Invalid salary amount");
        }
    }

    // Public method to access salary
    public double getSalary() {
        return salary;
    }

    // MAIN method (entry point)
    public static void main(String[] args) {

        Manager manager =
                new Manager(1001, "IT", 75000, "Krishna");

        manager.displayManagerDetails();

        // Modify salary using public method
        manager.updateSalary(85000);
        System.out.println("Updated Salary: ₹" + manager.getSalary());
    }
}

// Subclass
class Manager extends Employee {

    private String managerName;

    // Constructor
    public Manager(int employeeID, String department,
                   double salary, String managerName) {
        super(employeeID, department, salary);
        this.managerName = managerName;
    }

    // Demonstrating access to public and protected members
    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);     // public
        System.out.println("Department: " + department);      // protected
        System.out.println("Manager Name: " + managerName);
        System.out.println("Salary: ₹" + getSalary());        // private via method
        System.out.println("---------------------------");
    }
}