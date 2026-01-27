package com.reflection.jsonrepresentation;

import java.util.Scanner;

public class JsonReflection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        // Create object
        Student student = new Student(id, name, course);

        // Convert object to JSON using Reflection
        String jsonOutput = JsonUtil.toJson(student);

        System.out.println("\nGenerated JSON:");
        System.out.println(jsonOutput);

        scanner.close();
    }
}
