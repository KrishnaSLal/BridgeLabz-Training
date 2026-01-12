package com.artify;

class User {

    private String name;
    private double walletBalance;

    public User(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void deductAmount(double amount) {
        walletBalance -= amount;   // operator usage
    }

    public String getName() {
        return name;
    }
}
