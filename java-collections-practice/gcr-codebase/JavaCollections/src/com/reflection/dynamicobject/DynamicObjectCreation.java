package com.reflection.dynamicobject;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class DynamicObjectCreation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Take user input
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            // Load class dynamically
            Class<?> clazz = Class.forName("Student");

            // Get parameterized constructor
            Constructor<?> constructor =
                    clazz.getDeclaredConstructor(int.class, String.class);

            // Create object dynamically (no new keyword)
            Object obj = constructor.newInstance(id, name);

            // Cast and call method
            Student student = (Student) obj;
            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
