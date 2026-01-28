package com.csvdatahandling.basicproblems.writecsvfile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteCSVFile{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String fileName = "employees.csv";

        try (FileWriter writer = new FileWriter(fileName)) {

            // Write CSV header
            writer.append("ID,Name,Department,Salary\n");

            System.out.print("Enter number of employees: ");
            int count = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= count; i++) {
                System.out.println("\nEnter details for Employee " + i);

                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Department: ");
                String department = scanner.nextLine();

                System.out.print("Salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();

                // Write record to CSV
                writer.append(id + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("\nEmployee data written to CSV file successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to CSV file");
            e.printStackTrace();
        }

        scanner.close();
    }
}
