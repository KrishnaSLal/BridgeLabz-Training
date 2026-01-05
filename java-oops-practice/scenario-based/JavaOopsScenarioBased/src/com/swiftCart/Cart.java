package com.swiftCart;

import java.util.ArrayList;

public class Cart implements ICheckout {

    private ArrayList<Product> products;
    private double totalPrice;

    // Empty cart
    public Cart() {
        products = new ArrayList<>();
        totalPrice = 0;
    }

    // Pre-filled cart
    public Cart(ArrayList<Product> products) {
        this.products = products;
        calculateTotal();
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        totalPrice += product.getPrice() * quantity; // operator *
    }

    private void calculateTotal() {
        totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.getPrice();
        }
    }

    @Override
    public void applyDiscount(double coupon) {
        double productDiscount = 0;

        for (Product p : products) {
            productDiscount += p.getDiscount(); // polymorphism
        }

        totalPrice = totalPrice - productDiscount - coupon; // operator -
    }

    @Override
    public void generateBill() {
        System.out.println("----- SwiftCart Bill -----");
        for (Product p : products) {
            System.out.println(p.getName() + " - ₹" + p.getPrice());
        }
        System.out.println("Total Payable: ₹" + totalPrice);
    }
}
