package com.regex.extractdates;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = sc.nextLine();

        Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        
        System.out.println("Dates are: ");
        
        while (matcher.find()) {
        	
            System.out.println( matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("No dates found.");
        }

        sc.close();
    }
}
