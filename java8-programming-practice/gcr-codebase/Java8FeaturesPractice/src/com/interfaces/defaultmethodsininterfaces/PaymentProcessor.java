package com.interfaces.defaultmethodsininterfaces;

interface PaymentProcessor {

    // Existing abstract method
    void processPayment(double amount);

    // New feature added safely
    default void refund(double amount) {
        System.out.println("Refund of Rs." + amount + " processed using standard flow.");
    }
}
