package com.reflection.retrieveannotationsatruntime;

import java.util.Scanner;

public class RetrieveAnnotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter class name: ");
            String className = scanner.nextLine();

            // Automatically add package name
            String fullClassName = "com.reflection.retrieveannotationsatruntime." + className;

            Class<?> clazz = Class.forName(fullClassName);

            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Author Name: " + author.name());
            } else {
                System.out.println("Author annotation not found.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found. Please enter correct class name.");
        } finally {
            scanner.close();
        }
    }
}
