package com.regex.validatelicenseplatenumber;

import java.util.Scanner;

public class LicensePlateValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter license plate number: ");
        String plate = sc.nextLine();

        if (isValidPlate(plate)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        sc.close();
    }

    public static boolean isValidPlate(String plate) {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        return plate.matches(regex);
    }
}
