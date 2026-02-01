package com.csvdatahandling.advancedproblems.largecsvfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateLargeCsv {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\csvdatahandling\\advancedproblems\\largecsvfile\\largefile.csv";
        int totalLines = 1_000_000;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            bw.write("id,name,age,marks");
            bw.newLine();

            for (int i = 1; i <= totalLines; i++) {
                bw.write(i + ",Student" + i + "," + (18 + i % 10) + "," + (50 + i % 50));
                bw.newLine();

                if (i % 100_000 == 0) {
                    System.out.println(i + " records written");
                }
            }

            System.out.println("Large CSV file created successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
