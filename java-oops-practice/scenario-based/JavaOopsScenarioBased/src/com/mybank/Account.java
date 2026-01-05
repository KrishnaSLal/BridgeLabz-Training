package com.mybank;

abstract class Account implements ITransaction {

    protected String accountNumber;
    private double balance;   // encapsulated

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.print("Withdrawal successfull!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public double checkBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract double calculateInterest();
}
