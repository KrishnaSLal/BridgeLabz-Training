package com.regex.extractprogramminglanguage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageIdentifier {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = sc.nextLine();

        // List of programming languages
        String[] languages = {"Java", "Python", "JavaScript", "Go"};

        // Build regex: \b(Java|Python|JavaScript|Go)\b
        String regex = "\\b(" + String.join("|", languages) + ")\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("No programming languages found.");
        }

        sc.close();
    }
}
