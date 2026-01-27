package com.annotations.methodexecutiontime;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MainLogExecutionTime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PerformanceService service = new PerformanceService();
        Class<?> clazz = service.getClass();

        try {
            System.out.println("Available methods:");
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent(LogExecutionTime.class)) {
                    System.out.println("- " + m.getName());
                }
            }

            System.out.print("\nEnter method name to execute: ");
            String methodName = scanner.nextLine();

            Method method = clazz.getMethod(methodName);

            if (!method.isAnnotationPresent(LogExecutionTime.class)) {
                System.out.println("Method is not annotated with @LogExecutionTime");
                return;
            }

            long startTime = System.nanoTime();
            method.invoke(service);
            long endTime = System.nanoTime();

            System.out.println(
                "Execution Time of " + methodName + ": " +
                (endTime - startTime) + " ns"
            );

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
