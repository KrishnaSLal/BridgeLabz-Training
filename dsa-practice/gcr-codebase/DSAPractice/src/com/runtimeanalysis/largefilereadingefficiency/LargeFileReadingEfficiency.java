package com.runtimeanalysis.largefilereadingefficiency;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LargeFileReadingEfficiency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        try {
            long startTime = System.currentTimeMillis();

            FileReader fileReader = new FileReader(filePath);
            while (fileReader.read() != -1) {
            }
            fileReader.close();

            long endTime = System.currentTimeMillis();
            System.out.println("FileReader Time: " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            System.out.println("Error using FileReader: " + e.getMessage());
        }


        try {
            long startTime = System.currentTimeMillis();

            InputStreamReader inputStreamReader =
                    new InputStreamReader(new FileInputStream(filePath));

            while (inputStreamReader.read() != -1) {
            }
            inputStreamReader.close();

            long endTime = System.currentTimeMillis();
            System.out.println("InputStreamReader Time: " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            System.out.println("Error using InputStreamReader: " + e.getMessage());
        }

        scanner.close();
    }
}