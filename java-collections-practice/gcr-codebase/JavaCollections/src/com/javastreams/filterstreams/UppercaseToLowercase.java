package com.javastreams.filterstreams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UppercaseToLowercase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source text file path: ");
        String sourceFile = sc.nextLine();

        System.out.print("Enter destination file path: ");
        String destinationFile = sc.nextLine();

        File src = new File(sourceFile);
        if (!src.exists()) {
            System.out.println("Source file does not exist!");
            sc.close();
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(sourceFile),
                            StandardCharsets.UTF_8));

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(destinationFile),
                            StandardCharsets.UTF_8))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("File converted to lowercase successfully.");

        } catch (IOException e) {
            System.out.println("Error while processing files.");
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
