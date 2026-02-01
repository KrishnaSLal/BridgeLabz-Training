package com.csvdatahandling.advancedproblems.csvdatatojavaobjects;

import java.io.*;
import java.util.*;

public class CsvToJavaObject {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        String filePath = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\csvdatahandling\\advancedproblems\\csvdatatojavaobjects\\students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); 

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                double marks = Double.parseDouble(data[3]);

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print Student objects
        students.forEach(System.out::println);
    }
}
