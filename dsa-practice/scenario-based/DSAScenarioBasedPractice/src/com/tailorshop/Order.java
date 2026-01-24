package com.tailorshop;

public class Order {

    private int orderId;
    private String customerName;
    private int deliveryDeadline;

    public Order(int orderId, String customerName, int deliveryDeadline) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.deliveryDeadline = deliveryDeadline;
    }

    public int getDeliveryDeadline() {
        return deliveryDeadline;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Deadline: " + deliveryDeadline + " days";
    }
}
