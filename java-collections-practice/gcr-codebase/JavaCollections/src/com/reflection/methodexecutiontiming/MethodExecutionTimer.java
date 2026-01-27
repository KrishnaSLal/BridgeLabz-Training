package com.reflection.methodexecutiontiming;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodExecutionTimer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter fully qualified class name: ");
            String className = scanner.nextLine();

            Class<?> clazz = Class.forName(className);

            Object obj = clazz.getDeclaredConstructor().newInstance();

            System.out.print("Enter method name to time: ");
            String methodName = scanner.nextLine();

            Method method = clazz.getMethod(methodName);

            // Measure execution time
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Execution time of " + methodName + ": " + duration + " ns");

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
