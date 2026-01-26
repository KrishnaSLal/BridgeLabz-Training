package com.exceptions.trywithresource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TryWithResource {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file name to read: ");
        String fileName = sc.nextLine();

        // try-with-resources ensures automatic closing
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line of the file: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        } finally {
            sc.close();
        }
    }
}
