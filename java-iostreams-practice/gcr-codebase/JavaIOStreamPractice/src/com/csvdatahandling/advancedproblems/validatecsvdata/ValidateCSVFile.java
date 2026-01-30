package com.csvdatahandling.advancedproblems.validatecsvdata;


// Validate CSV Data Before Processing:
//
//Ensure that the "Email" column follows a valid email format using regex.
//Ensure that "Phone Numbers" contain exactly 10 digits.
//Print any invalid rows with an error message.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateCSVFile {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private static final String PHONE_REGEX = "^\\d{10}$";

    public static void main(String[]args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CSV file path: ");
        String filePath = scanner.nextLine();

        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            int rowNumber = 0;

            // Skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                rowNumber++;

                String[] data = line.split(",");

                if (data.length < 6) {
                    System.out.println("Row " + rowNumber + "Invalid column count : " + line);
                    continue;
                }

                String email = data[2].trim();
                String phone = data[3].trim();

                boolean valid = true;

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Row " + rowNumber + "Invalid Email: " + email);
                    valid = false;
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Row " + rowNumber + "Invalid Phone Number: " + phone);
                    valid = false;
                }

                if (!valid) {
                    System.out.println("Invalid Row Data: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        scanner.close();
    }
}
