package com.exceptions.finallyblockexecution;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyBlock {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = sc.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = sc.nextInt();

            int result = numerator / denominator;
            System.out.println("Result of division: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers.");

        } finally {
            // This always executes
            System.out.println("Operation completed");
            sc.close();
        }
    }
}
