package com.zipzipmart;

import java.time.LocalDate;

public class SaleTransaction {
    private int transactionId;
    private LocalDate date;
    private double amount;

    public SaleTransaction(int transactionId, LocalDate date, double amount) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "TxnID: " + transactionId +", Date: " + date +", Amount: ₹" + amount;
    }
}