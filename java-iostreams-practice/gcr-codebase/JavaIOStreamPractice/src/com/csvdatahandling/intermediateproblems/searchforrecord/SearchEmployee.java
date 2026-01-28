package com.csvdatahandling.intermediateproblems.searchforrecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployee{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();

        String filePath = "employees.csv";
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[1];

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("\nEmployee Found");
                    System.out.println("Department : " + data[2]);
                    System.out.println("Salary     : " + data[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("\nEmployee not found");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}
