package com.javastreams.filehandling;

import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the source file path: ");
        String sourceFile = sc.nextLine();

        System.out.print("Enter the destination file path: ");
        String destinationFile = sc.nextLine();

        File src = new File(sourceFile);
        if (!src.exists()) {
            System.out.println("Source file does not exist: " + sourceFile);
            sc.close();
            return;
        }

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }

            System.out.println("File copied successfully to: " + destinationFile);

        } catch (IOException e) {
            System.out.println("An error occurred during file operation: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
