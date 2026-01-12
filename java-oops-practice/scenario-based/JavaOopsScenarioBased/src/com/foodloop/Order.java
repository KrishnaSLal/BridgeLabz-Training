package com.foodloop;

import java.util.List;

class Order implements IOrderable {

    private List<FoodItem> items;
    private double total;

    // Constructor for combo meal
    public Order(List<FoodItem> items) {
        this.items = items;
        calculateTotal();
    }

    private void calculateTotal() {
        total = 0;
        for (FoodItem item : items) {
            total += item.getPrice();   // operator usage
        }
        total -= applyDiscount(total);
    }

    // Polymorphic discount logic
    protected double applyDiscount(double amount) {
        if (amount > 1000) {
            return amount * 0.15;
        } else if (amount > 500) {
            return amount * 0.10;
        }
        return 0;
    }

    @Override
    public void placeOrder() {

        for (FoodItem item : items) {
            if (!item.isAvailable()) {
                System.out.println(item.getName() + " is out of stock.");
                return;
            }
            item.reduceStock();
        }

        System.out.println("Order placed successfully!");
        System.out.println("Total Bill Amount: ₹" + total);
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order cancelled. Refund initiated.");
    }
}
