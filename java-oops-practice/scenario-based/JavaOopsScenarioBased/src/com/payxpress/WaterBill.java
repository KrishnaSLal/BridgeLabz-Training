package com.payxpress;

import java.time.LocalDate;

public class WaterBill extends Bill {

    public WaterBill(double amount, LocalDate dueDate) {
        super("Water", amount, dueDate);
    }

    @Override
    public void sendReminder() {
        if (!isPaid()) {
            double lateAmount = calculateLateFee(50);
            System.out.println("Water Bill Reminder!");
            System.out.println("Late payment will cost Rs." + lateAmount);
        }
    }
}
