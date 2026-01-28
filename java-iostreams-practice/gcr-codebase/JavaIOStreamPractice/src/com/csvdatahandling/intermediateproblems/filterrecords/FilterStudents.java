package com.csvdatahandling.intermediateproblems.filterrecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FilterStudents {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take CSV file path from user
        System.out.print("Enter CSV file path: ");
        String filePath = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean isHeader = true;

            System.out.println("\nStudents scoring more than 80 marks:\n");

            while ((line = br.readLine()) != null) {

                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                int marks = Integer.parseInt(data[3].trim());

                if (marks > 80) {
                    System.out.println("ID: " + data[0] +", Name: " + data[1] +", Age: "+ data[2] + ", Marks: " +marks);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file. Check file path.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid marks value in CSV.");
        }

        scanner.close();
    }
}
