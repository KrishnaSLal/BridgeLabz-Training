package com.annotations.customannotation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MainTaskInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            TaskManager taskManager = new TaskManager();

            System.out.println("Available methods: completeTask, reviewTask");
            System.out.print("Enter method name to view annotation info: ");
            String methodName = scanner.nextLine();

            Method method = TaskManager.class.getMethod(methodName);

            // Check if @TaskInfo is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                System.out.println("\nAnnotation Details:");
                System.out.println("Priority   : " + taskInfo.priority());
                System.out.println("AssignedTo : " + taskInfo.assignedTo());

                // Optionally call the method
                System.out.println("\nCalling the method dynamically\n");
                method.invoke(taskManager);

            } else {
                System.out.println("No @TaskInfo annotation found on this method.");
            }

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
