package com.csvdatahandling.advancedproblems.detectduplicates;

import java.io.*;
import java.util.*;

public class DetectDuplicate {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\csvdatahandling\\advancedproblems\\detectduplicates\\students.csv";

        Set<String> seenIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            String header = br.readLine();
            System.out.println("Header: " + header);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                if (!seenIds.add(id)) {
                 
                    duplicates.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print duplicates
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found");
        } else {
            System.out.println("Duplicate records:");
            duplicates.forEach(System.out::println);
        }
    }
}
