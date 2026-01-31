//In an employee system, check if salary is greater than 30,000 using Predicate.

package com.functionalinterface.predicate.employeesystem;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
public class MainEmployee {
    public static void main(String[] args) {

        Employee e1 = new Employee("Rahul", 45000);
        Employee e2 = new Employee("Neha", 25000);

        Salary salaryCheck =e -> e.salary > 30000;

        System.out.println("This employee's salary is higher than 30,000: "+ salaryCheck.check(e1));
        System.out.println("This employee's salary is higher than 30,000: "+ salaryCheck.check(e2));
    }
}
