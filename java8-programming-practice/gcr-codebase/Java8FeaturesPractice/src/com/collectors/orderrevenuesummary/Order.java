package com.collectors.orderrevenuesummary;

class Order {
    String customerName;
    double amount;

    Order(String customerName, double amount) {
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }
}
