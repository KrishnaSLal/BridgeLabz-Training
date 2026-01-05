package com.ewalletapllication;

abstract class Wallet implements Transferrable {
    private double balance;

    // Normal wallet
    public Wallet(double initialBalance) {
        this.balance = initialBalance;
    }

    // Wallet with referral bonus
    public Wallet(double initialBalance, double referralBonus) {
        this.balance = initialBalance + referralBonus;
    }

    protected boolean deduct(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    protected void add(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
