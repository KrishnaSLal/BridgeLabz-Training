package com.exceptions.uncheckedexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {

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
            System.out.println("ArithmeticException: Division by zero is not allowed.");

        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException: Please enter valid numeric values.");

        } finally {
            sc.close();
        }
    }
}
