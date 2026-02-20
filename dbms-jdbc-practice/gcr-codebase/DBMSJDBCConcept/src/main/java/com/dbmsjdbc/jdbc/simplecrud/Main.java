package com.dbmsjdbc.jdbc.simplecrud;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initialize();  // create table

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search by Name");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(name, salary));
                    break;

                case 2:
                    List<Employee> list = dao.getAllEmployees();
                    for (Employee e : list) {
                        System.out.println(
                                e.getId() + " | " +
                                e.getName() + " | " +
                                e.getSalary());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    dao.updateSalary(id, newSalary);
                    break;

                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter Name to Search: ");
                    String search = sc.nextLine();
                    dao.searchByName(search);
                    break;

                case 6:
                    System.out.println("Exiting");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}