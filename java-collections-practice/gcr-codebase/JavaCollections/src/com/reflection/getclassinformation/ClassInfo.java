package com.reflection.getclassinformation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter fully qualified class name: ");
        String className = scanner.nextLine();

        try {
            // Load the class dynamically
            Class<?> clazz = Class.forName(className);

            System.out.println("\nClass Name: " + clazz.getName());

            //Constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Fields
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Methods
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found. Please check the class name.");
        } finally {
            scanner.close();
        }
    }
}
