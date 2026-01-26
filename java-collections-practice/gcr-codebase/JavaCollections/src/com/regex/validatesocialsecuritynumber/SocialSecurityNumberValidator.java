package com.regex.validatesocialsecuritynumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocialSecurityNumberValidator{

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text containing SSN:");
        String text = sc.nextLine();

        // Regex for SSN
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group() + " is valid");
            found = true;
        }

        if (!found) {
            System.out.println("No valid SSN found.");
        }

        sc.close();
    }
}
