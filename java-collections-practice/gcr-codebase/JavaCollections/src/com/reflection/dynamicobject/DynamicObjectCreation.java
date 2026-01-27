package com.reflection.dynamicobject;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class DynamicObjectCreation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            
            Class<?> clazz = Class.forName("com.reflection.dynamicobject.Student");

            Constructor<?> constructor =
                clazz.getDeclaredConstructor(int.class, String.class);

            Object obj = constructor.newInstance(id, name);

            Student student = (Student) obj;
            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
