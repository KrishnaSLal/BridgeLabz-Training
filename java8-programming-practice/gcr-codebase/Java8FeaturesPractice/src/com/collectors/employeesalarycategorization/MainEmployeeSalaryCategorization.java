//Employee Salary Categorization
//You have a list of employees with their departments and salaries. Use
//Collectors.groupingBy() to group employees by department and calculate the
//average salary for each department.


package com.collectors.employeesalarycategorization;

import java.util.*;
import java.util.stream.Collectors;

public class MainEmployeeSalaryCategorization {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employees.add(new Employee(name, department, salary));
        }

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));


        System.out.println("\nAverage Salary per Department:");
        avgSalaryByDept.forEach((dept, avgSalary) ->
                System.out.println(dept + " - Rs." + avgSalary));

        sc.close();
    }
}
