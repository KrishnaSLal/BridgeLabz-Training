package com.javacollectionframework.map.groupobjectbyproperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainEmployeeGrouper {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            String name = sc.next();

            System.out.print("Enter department: ");
            String dept = sc.next();

            employees.add(new Employee(name, dept));
        }

        Map<String, List<Employee>> grouped =
                EmployeeGrouper.groupByDepartment(employees);

        System.out.println("\nEmployees Grouped by Department:");
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sc.close();
    }
}
