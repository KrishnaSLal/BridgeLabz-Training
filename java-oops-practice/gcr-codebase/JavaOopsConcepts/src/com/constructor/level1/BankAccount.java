package com.constructor.level1;

// Parent class
public class BankAccount {

    // Access modifiers
    public String accountNumber;        // public
    protected String accountHolder;     // protected
    private double balance;             // private

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to access balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify balance (deposit)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Public method to modify balance (withdraw)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    // MAIN method (entry point)
    public static void main(String[] args) {

        SavingsAccount savings =
                new SavingsAccount("ACC101", "Krishna", 5000);

        savings.displayAccountDetails();

        savings.deposit(2000);
        savings.withdraw(1500);

        System.out.println("Final Balance: ₹" + savings.getBalance());
    }
}

// Subclass
class SavingsAccount extends BankAccount {

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    // Demonstrating access modifiers
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);      // public
        System.out.println("Account Holder: " + accountHolder);      // protected
        System.out.println("Balance: ₹" + getBalance());             // private via method
        System.out.println("---------------------------");
    }
}
