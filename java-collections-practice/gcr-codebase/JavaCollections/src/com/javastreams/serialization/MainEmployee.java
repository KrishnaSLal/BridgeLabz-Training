package com.javastreams.serialization;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MainEmployee {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Employee> employees = new ArrayList<>();

        try {
            System.out.print("Enter number of employees: ");
            int count = Integer.parseInt(br.readLine());

            for (int i = 1; i <= count; i++) {
                System.out.println("\nEnter details for Employee " + i);

                System.out.print("ID: ");
                int id = Integer.parseInt(br.readLine());

                System.out.print("Name: ");
                String name = br.readLine();

                System.out.print("Department: ");
                String department = br.readLine();

                System.out.print("Salary: ");
                double salary = Double.parseDouble(br.readLine());

                employees.add(new Employee(id, name, department, salary));
            }

            // Serialize
            EmployeeManager.saveEmployees(employees);

            // Deserialize
            System.out.println("\nEmployees retrieved from file:");
            List<Employee> storedEmployees = EmployeeManager.loadEmployees();

            if (storedEmployees != null) {
                storedEmployees.forEach(System.out::println);
            }

        } catch (IOException e) {
            System.out.println("Input error occurred.");
            e.printStackTrace();
        }
    }
}
