package com.encapsulationandpolymorphism.onlinefooddeliverysystem;

import java.util.List;

class OrderService {

    public static void processOrder(List<FoodItem> items) {

        double grandTotal = 0;

        for (FoodItem item : items) {

            item.getItemDetails();

            double totalPrice = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                discount = d.applyDiscount();
                System.out.println("Discount: ₹" + discount);
                System.out.println("Discount Info: " + d.getDiscountDetails());
            }

            double finalPrice = totalPrice - discount;
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println("--------------------------");

            grandTotal += finalPrice;
        }

        System.out.println("Grand Total: ₹" + grandTotal);
    }
}
