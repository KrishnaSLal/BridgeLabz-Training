package com.exceptions.throwvsthrow;

import java.util.Scanner;

public class ThrowVSThrow {

    // Method calculates simple interest and propagates exception
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter principal amount: ");
            double amount = sc.nextDouble();

            System.out.print("Enter interest rate: ");
            double rate = sc.nextDouble();

            System.out.print("Enter number of years: ");
            int years = sc.nextInt();

            // Call method that can throw exception
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}
