package com.csvdatahandling.intermediateproblems.sortrecords;

import java.io.*;
import java.util.*;

public class MainEmployee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Employee emp = new Employee(Integer.parseInt(data[0]),data[1],data[2],Double.parseDouble(data[3]));

                employees.add(emp);
            }

            System.out.println("\nTop 5 Highest Paid Employees:\n");

            employees.stream()
                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .limit(5)
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            
            sc.close();
        }
    }
}
