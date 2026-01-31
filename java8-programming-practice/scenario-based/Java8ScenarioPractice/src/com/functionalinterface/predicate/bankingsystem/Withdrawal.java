package com.functionalinterface.predicate.bankingsystem;

@FunctionalInterface
interface WithdrawalCheck {
    boolean isValid(double amount, BankAccount account);
}
