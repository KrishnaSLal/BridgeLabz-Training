package com.javastreams.readlargefile;

import java.io.*;
import java.util.Scanner;

public class ErrorLogReader {

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = sc.nextLine();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            sc.close();
            return;
        }

        System.out.println("\nLines containing 'error':\n");

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {

                // Case-insensitive check
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error while reading the file.");
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
