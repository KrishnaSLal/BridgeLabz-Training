package com.inheritance.hierarchialinheritance.bankaccounttype;

class BankAccount {

    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() {
        System.out.println("Generic Bank Account");
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}
