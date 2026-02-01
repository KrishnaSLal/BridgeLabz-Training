package com.csvdatahandling.advancedproblems.mergecsvfiles;

import java.io.*;
import java.util.*;

public class MergeCsvFiles {

    public static void main(String[] args) {

        String file1 = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\csvdatahandling\\advancedproblems\\mergecsvfiles\\students1.csv";
        String file2 = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\csvdatahandling\\advancedproblems\\mergecsvfiles\\students2.csv";
        String outputFile = "C:\\\\Users\\\\krish\\\\OneDrive\\\\Desktop\\\\BridgeLabz-Training\\\\java-iostreams-practice\\\\gcr-codebase\\\\JavaIOStreamPractice\\\\src\\\\com\\\\csvdatahandling\\\\advancedproblems\\\\mergecsvfiles\\\\merged_students.csv";

        Map<Integer, Student> studentMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {

            String line = br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                studentMap.put(id, new Student(id, name, age));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                int marks = Integer.parseInt(data[1]);
                String grade = data[2];

                Student student = studentMap.get(id);
                if (student != null) {
                    student.marks = marks;
                    student.grade = grade;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            bw.write("id,name,age,marks,grade");
            bw.newLine();

            for (Student s : studentMap.values()) {
                bw.write(s.id + "," + s.name + "," + s.age + "," +s.marks + "," +s.grade);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("CSV files merged successfully!");
    }
}
