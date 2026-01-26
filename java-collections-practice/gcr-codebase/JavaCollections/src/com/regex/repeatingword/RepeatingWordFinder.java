package com.regex.repeatingword;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;

public class RepeatingWordFinder{

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        // Regex for consecutive repeating words (case-insensitive)
        Pattern pattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        HashSet<String> repeats = new HashSet<>();

        while (matcher.find()) {
            repeats.add(matcher.group(1).toLowerCase()); // store lowercase to avoid duplicates
        }

        if (repeats.isEmpty()) {
            System.out.println("No repeating words found.");
        } else {
            System.out.println("Repeating words:");
            for (String word : repeats) {
                System.out.println(word);
            }
        }

        sc.close();
    }
}
