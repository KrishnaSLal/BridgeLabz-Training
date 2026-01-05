package com.swiftCart;

public interface ICheckout {
    void generateBill();
    void applyDiscount(double coupon);
}
