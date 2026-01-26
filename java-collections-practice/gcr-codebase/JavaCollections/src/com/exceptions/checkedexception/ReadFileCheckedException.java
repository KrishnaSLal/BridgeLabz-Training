package com.exceptions.checkedexception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileCheckedException {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name to read: ");
        String fileName = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            System.out.println("\nFile contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Checked exception handling
            System.out.println("File not found");
        } finally {
            sc.close();
        }
    }
}
