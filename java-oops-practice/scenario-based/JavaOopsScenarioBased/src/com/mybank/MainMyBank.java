package com.mybank;

import java.util.Scanner;

public class MainMyBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account account;

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter Opening Balance: ");
            double balance = sc.nextDouble();
            account = new SavingsAccount(accNo, balance);
        } else {
            account = new CurrentAccount(accNo);
        }

        int option;
        do {
            System.out.println("\n--- MyBank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Calculate Interest");
            System.out.println("5. Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(sc.nextDouble());
                    System.out.print("Amount deposited successfully!");
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Balance: " + account.checkBalance());
                    break;

                case 4:
                    System.out.println("Interest: " + account.calculateInterest());
                    break;

                case 5:
                    System.out.println("Thank you for using MyBank!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
            
        } while (option != 5);

        sc.close();
    }
}
