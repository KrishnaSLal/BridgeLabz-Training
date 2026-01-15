package com.payxpress;

import java.time.LocalDate;

public class InternetBill extends Bill {

    public InternetBill(double amount, LocalDate dueDate) {
        super("Internet", amount, dueDate);
    }

    @Override
    public void sendReminder() {
        if (!isPaid()) {
            double lateAmount = calculateLateFee(150);
            System.out.println("Internet Bill Reminder!");
            System.out.println("Service disruption if unpaid. Pay Rs." + lateAmount);
        }
    }
}
