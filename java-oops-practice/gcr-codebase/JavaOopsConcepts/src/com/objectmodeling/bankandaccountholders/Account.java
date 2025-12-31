package com.objectmodeling.bankandaccountholders;

public class Account {

    private int accountNumber;
    private double balance;
    private Bank bank; // Association with Bank

    public Account(int accountNumber, Bank bank) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}
