package com.csvdatahandling.intermediateproblems.modifycsvfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ModifyEmployee{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take input file path from user
        System.out.print("Enter input CSV file path: ");
        String inputFile = scanner.nextLine();

        // Output file (can be fixed or customized)
        String outputFile = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\csvdatahandling\\intermediateproblems\\modifycsvfile\\updated_employees.csv";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {

            String line;

            // Read and write header
            line = reader.readLine();
            writer.write(line);
            writer.newLine();

            // Process records
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String department = data[2].trim();
                double salary = Double.parseDouble(data[3].trim());

                // Increase salary for IT department
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10;
                }

                // Write updated record
                writer.write(id + "," + name + "," + department + "," + salary);
                writer.newLine();
            }

            System.out.println("\nSalary updated successfully!");
            System.out.println("Output file created: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
