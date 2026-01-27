package com.reflection.dynamicmethodinvocation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Take user input
            System.out.print("Enter method name (add / subtract / multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter second number: ");
            int b = scanner.nextInt();

            // Load class dynamically
            Class<?> clazz =
                    Class.forName("com.reflection.dynamicmethodinvocation.MathOperations");

            // Create object dynamically
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // Get method based on user input
            Method method =
                    clazz.getMethod(methodName, int.class, int.class);

            // Invoke method
            int result = (int) method.invoke(obj, a, b);

            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name entered!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
