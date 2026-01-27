package com.annotations.repeatableannotation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MainRepeatableAnnotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            TaskHandler handler = new TaskHandler();

            System.out.println("Available method: processTask");
            System.out.print("Enter method name to view bug reports: ");
            String methodName = scanner.nextLine();

            Method method = TaskHandler.class.getMethod(methodName);

            // Get all @BugReport annotations (repeatable)
            if (method.isAnnotationPresent(BugReport.class) || method.isAnnotationPresent(BugReports.class)) {

                BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

                System.out.println("\nBug Reports for method '" + methodName + "':");
                for (int i = 0; i < bugReports.length; i++) {
                    System.out.println((i + 1) + ". " + bugReports[i].description());
                }

                // Optionally call the method
                System.out.println("\nCalling the method dynamically...");
                method.invoke(handler);

            } else {
                System.out.println("No BugReport annotation found on this method.");
            }

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
