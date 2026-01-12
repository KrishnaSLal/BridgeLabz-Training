package com.searching.stringbuilder.removeduplicates;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Step 1: Initialize StringBuilder
        StringBuilder sb = new StringBuilder();

        // Step 2: HashSet to track characters
        HashSet<Character> set = new HashSet<>();

        // Step 3: Iterate through the string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Step 4: Append only if not already present
            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }

        // Step 5: Convert to String
        String result = sb.toString();

        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}
