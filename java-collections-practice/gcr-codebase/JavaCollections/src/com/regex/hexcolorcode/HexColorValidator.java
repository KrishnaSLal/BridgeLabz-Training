package com.regex.hexcolorcode;

import java.util.Scanner;

public class HexColorValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hex color code: ");
        String color = sc.nextLine();

        if (isValidHexColor(color)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        sc.close();
    }

    public static boolean isValidHexColor(String color) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        return color.matches(regex);
    }
}
