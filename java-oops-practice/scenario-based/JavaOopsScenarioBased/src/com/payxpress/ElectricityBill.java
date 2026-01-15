package com.payxpress;

import java.time.LocalDate;

public class ElectricityBill extends Bill {

    public ElectricityBill(double amount, LocalDate dueDate) {
        super("Electricity", amount, dueDate);
    }

    @Override
    public void sendReminder() {
        if (!isPaid()) {
            double lateAmount = calculateLateFee(100);
            System.out.println("Electricity Bill Reminder!");
            System.out.println("Pay before " + dueDate +
                    " or amount becomes Rs." + lateAmount);
        }
    }
}
