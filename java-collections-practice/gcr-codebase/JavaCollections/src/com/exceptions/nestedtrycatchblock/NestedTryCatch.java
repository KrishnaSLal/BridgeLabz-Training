package com.exceptions.nestedtrycatchblock;

import java.util.Scanner;

public class NestedTryCatch{

    public static void main(String[]args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Take array size
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();

            int[] arr = new int[size];

            // Take array elements
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            // Take index
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();

            try {
                int value = arr[index]; // May throw ArrayIndexOutOfBoundsException

                // Take divisor
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                try {
                    int result = value / divisor; // May throw ArithmeticException
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index");
            }

        } finally {
            scanner.close();
        }
    }
}
