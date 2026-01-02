package com.encapsulationandpolymorphism.ecommerceplatform;

import java.util.List;

class BillingService {

    public static void printFinalPrice(List<Product> products) {

        for (Product p : products) {

            double tax = 0;

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
            }

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            p.displayProduct();
            System.out.println("Discount: ₹" + discount);
            System.out.println("Tax: ₹" + tax);
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println("----------------------------");
        }
    }
}
