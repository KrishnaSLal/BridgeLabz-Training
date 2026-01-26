package com.regex.validatecreditcardnumber;

import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter credit card number: ");
        String card = sc.nextLine();

        if (isValidCard(card)) {
            System.out.println("Valid credit card number");
        } else {
            System.out.println("Invalid credit card number");
        }

        sc.close();
    }

    public static boolean isValidCard(String card) {
        String regex = "^(4|5)\\d{15}$";
        return card.matches(regex);
    }
}
