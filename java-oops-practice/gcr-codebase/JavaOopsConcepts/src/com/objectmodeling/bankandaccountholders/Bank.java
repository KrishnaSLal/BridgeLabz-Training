package com.objectmodeling.bankandaccountholders;

public class Bank {

    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    // Bank opens an account for a customer
    public Account openAccount(Customer customer, int accountNumber) {
        Account account = new Account(accountNumber, this);
        customer.addAccount(account);
        System.out.println("Account opened for " + customer.getName()
                + " in " + bankName);
        return account;
    }

    public String getBankName() {
        return bankName;
    }
}
