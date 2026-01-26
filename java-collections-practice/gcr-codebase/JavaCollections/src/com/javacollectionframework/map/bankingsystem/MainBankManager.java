package com.javacollectionframework.map.bankingsystem;

import java.util.Scanner;

public class MainBankManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankManager bank = new BankManager();

        while (true) {
            System.out.println("\nBanking System Menu");
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Request Withdrawal");
            System.out.println("4. Process Next Withdrawal");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Display Accounts Sorted by Balance");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter account number: ");
                    String acc = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double bal = sc.nextDouble();
                    sc.nextLine();
                    bank.createAccount(acc, bal);
                }
                case 2 -> {
                    System.out.print("Enter account number: ");
                    String acc = sc.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    bank.deposit(acc, amt);
                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    String acc = sc.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    bank.requestWithdrawal(acc, amt);
                }
                case 4 -> bank.processWithdrawal();
                case 5 -> bank.displayAccounts();
                case 6 -> bank.displayAccountsSortedByBalance();
                case 7 -> {
                    System.out.println("Exiting Banking System");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
