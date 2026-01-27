package com.reflection.invokeprivatemethod;

import java.lang.reflect.Method;

import java.util.Scanner;

public class InvokePrivateMethod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Take user input
            System.out.print("Enter first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter second number: ");
            int b = scanner.nextInt();

            // Create object of Calculator
            Calculator calculator = new Calculator();

            // Get Class object
            Class<?> clazz = calculator.getClass();

            // Get private method multiply(int, int)
            Method method = clazz.getDeclaredMethod("multiply", int.class, int.class);

            // Make private method accessible
            method.setAccessible(true);

            // Invoke private method
            int result = (int) method.invoke(calculator, a, b);

            // Display result
            System.out.println("Result of multiplication: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
