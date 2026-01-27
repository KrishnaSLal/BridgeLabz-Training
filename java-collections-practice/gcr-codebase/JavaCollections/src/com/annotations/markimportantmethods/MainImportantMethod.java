package com.annotations.markimportantmethods;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MainImportantMethod{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Class<TaskManager> clazz = TaskManager.class;

            System.out.println("Retrieving all @ImportantMethod annotated methods...");

            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
                }
            }

            // Optional: allow user to call a method
            System.out.print("\nEnter method name to invoke: ");
            String methodName = scanner.nextLine();

            Method userMethod = clazz.getMethod(methodName);
            TaskManager manager = new TaskManager();
            userMethod.invoke(manager);

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
