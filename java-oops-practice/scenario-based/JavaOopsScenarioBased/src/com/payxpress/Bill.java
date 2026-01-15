package com.payxpress;

import java.time.LocalDate;

public abstract class Bill implements IPayable {

    protected String type;
    protected double amount;
    protected LocalDate dueDate;
    private boolean isPaid;

    // Constructor (supports recurring bills)
    public Bill(String type, double amount, LocalDate dueDate) {
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = false;
    }

    // Late fee calculation using operator
    protected double calculateLateFee(double penalty) {
        return amount + penalty;
    }

    // Encapsulation: no direct setter for isPaid
    protected void markPaid() {
        isPaid = true;
    }

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void pay() {
        if (isPaid) {
            System.out.println(type + " bill already paid.");
        } else {
            markPaid();
            System.out.println(type + " bill paid successfully. Amount: Rs." + amount);
        }
    }
}
