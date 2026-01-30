package com.functionalinterface.predicate.studentsystem.bankingsystem;

@FunctionalInterface
interface WithdrawalCheck {
    boolean isValid(double amount, BankAccount account);
}
