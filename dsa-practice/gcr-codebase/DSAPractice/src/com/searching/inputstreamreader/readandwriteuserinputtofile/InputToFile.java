package com.searching.inputstreamreader.readandwriteuserinputtofile;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class InputToFile {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path to write data: ");
        String filePath = scanner.nextLine();

        System.out.println("Enter text (type 'exit' to stop):");

        try (
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter writer = new FileWriter(filePath)
        ) {

            String line;

            while (true) {
                line = br.readLine();

                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(line);
                writer.write(System.lineSeparator());
            }

            System.out.println("Data successfully written to file.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}