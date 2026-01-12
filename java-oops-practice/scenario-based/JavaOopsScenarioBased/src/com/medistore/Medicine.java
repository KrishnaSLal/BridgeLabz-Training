package com.medistore;

import java.time.LocalDate;

abstract class Medicine implements ISellable {

    private String name;
    private double price;
    private int quantity;
    protected LocalDate expiryDate;

    // Constructor with default quantity
    public Medicine(String name, double price, LocalDate expiryDate) {
        this(name, price, expiryDate, 100);
    }

    // Constructor with custom quantity
    public Medicine(String name, double price, LocalDate expiryDate, int quantity) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    // Encapsulation: stock access via methods only
    public int getQuantity() {
        return quantity;
    }

    protected void reduceStock(int soldQty) {
        quantity -= soldQty;
    }

    // Sensitive pricing logic
    private double applyDiscount(double total) {
        if (total > 1000) {
            return total * 0.90; // 10% discount
        }
        return total;
    }

    protected double calculateTotalPrice(int qty) {
        double total = price * qty; // operator usage
        return applyDiscount(total);
    }

    @Override
    public void sell(int qty) {

        if (checkExpiry()) {
            System.out.println(name + " is expired. Cannot sell.");
            return;
        }

        if (qty > quantity) {
            System.out.println("Insufficient stock for " + name);
            return;
        }

        double billAmount = calculateTotalPrice(qty);
        reduceStock(qty);

        System.out.println("Sold " + qty + " units of " + name);
        System.out.println("Bill Amount: ₹" + billAmount);
    }
}
