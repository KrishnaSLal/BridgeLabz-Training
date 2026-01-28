package com.csvdatahandling.basicproblems.readandcountrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountRows {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take file path from user
        System.out.print("Enter CSV file path: ");
        String filePath = scanner.nextLine();

        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {

                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Count only non-empty rows
                if (!line.trim().isEmpty()) {
                    recordCount++;
                }
            }

            System.out.println("Total number of records (excluding header): " + recordCount);

        } catch (IOException e) {
            System.out.println("Error reading CSV file. Please check the path.");
        }

        scanner.close();
    }
}
