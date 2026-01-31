//In an employee system, check if salary is greater than 30,000 using Predicate.

package com.functionalinterface.predicate.employeesystem;

import java.util.function.Predicate;
import java.util.Scanner;

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

    	Scanner sc = new Scanner(System.in);
    	
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
        
        System.out.println("Enter the salary: ");
        double salary = sc.nextDouble();

        Employee employee = new Employee(name, salary);
        
        Predicate<Employee> highSalary = e -> e.salary > 30000;

        if (highSalary.test(employee)) {
            System.out.println("Salary is greater than 30000");
        } else {
            System.out.println("Salary is not greater than 30000");
        }

        
        sc.close();
    }
}

