package com.exceptions.multiplecatchblocks;

import java.util.Scanner;

public class ArrayException {

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = null;

        try {
            System.out.print("Enter size of array: ");
            int size = sc.nextInt();

            // Initialize array
            arr = new int[size];

            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter index to retrieve value: ");
            int index = sc.nextInt();

            // Access array element
            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");

        } finally {
            sc.close();
        }
    }
}
