package com.regex.replacemultiplespaceswithsinglespace;

import java.util.Scanner;

public class SpaceReplacing{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String input = sc.nextLine();

        // Replace multiple spaces with a single space
        String output = input.replaceAll("\\s+", " ");

        System.out.println("After replacing spaces:");
        System.out.println(output);

        sc.close();
    }
}
