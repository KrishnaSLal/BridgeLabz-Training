//In a bank application, validate whether withdrawal amount is valid using Predicate.

package com.functionalinterface.predicate.studentsystem.bankingsystem;

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }
}
public class MainBankingSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000);

        WithdrawalCheck check = (amount, acc) -> amount > 0 && amount <= acc.balance;

        System.out.println("Is this withdrawal valid? :" + check.isValid(5000, account));   
        System.out.println("Is this withdrawal valid? :" + check.isValid(15000, account)); 
    }
}
