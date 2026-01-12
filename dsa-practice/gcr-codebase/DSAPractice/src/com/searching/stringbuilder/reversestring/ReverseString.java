package com.searching.stringbuilder.reversestring;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Step 1: Create StringBuilder object
        StringBuilder sb = new StringBuilder();

        // Step 2: Append the string
        sb.append(input);

        // Step 3: Reverse the string
        sb.reverse();

        // Step 4: Convert back to String
        String reversed = sb.toString();

        System.out.println("Reversed string: " + reversed);

        sc.close();
    }
}
