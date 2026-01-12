package com.searching.stringbuffer.concatenatestrings;

import java.util.Scanner;

public class ConcatenateStrings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user for number of strings
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        // Create StringBuffer object
        StringBuffer buffer = new StringBuffer();

        // Take string inputs and append
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter string " + i + ": ");
            String input = sc.nextLine();
            buffer.append(input);
        }

        // Convert to String
        String result = buffer.toString();

        // Display result
        System.out.println("Concatenated String: " + result);

        sc.close();
    }
}
