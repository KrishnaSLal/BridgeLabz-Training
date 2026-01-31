//In a bank application, validate whether withdrawal amount is valid using Predicate.
package com.functionalinterface.predicate.bankingsystem;

import java.util.Scanner;
import java.util.function.Predicate;

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }
}

public class MainBankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        BankAccount account = new BankAccount(balance);

 
        Predicate<Double> validWithdrawal = amt -> amt > 0 && amt <= account.balance;


        System.out.println("Is this withdrawal possible? : " + validWithdrawal.test(amount));

        sc.close();
    }
}
