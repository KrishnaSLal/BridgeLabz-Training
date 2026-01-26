package com.regex.censorbadwords;

import java.util.Scanner;

public class BadWordCensor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        // List of bad words
        String[] badWords = {"damn", "stupid"};

        // Build regex pattern: \b(damn|stupid)\b
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        // Replace bad words with **** (case-insensitive)
        String censored = sentence.replaceAll("(?i)" + regex, "****");

        System.out.println("Censored output:");
        System.out.println(censored);

        sc.close();
    }
}
