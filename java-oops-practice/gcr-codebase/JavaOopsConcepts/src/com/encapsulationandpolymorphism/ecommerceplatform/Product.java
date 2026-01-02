package com.encapsulationandpolymorphism.ecommerceplatform;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
abstract class Product {

    // Encapsulation
    private int productId;
    private String name;
    protected double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Concrete method
    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: ₹" + price);
    }

    // Setters (controlled updates)
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    // Getters
    public double getPrice() {
        return price;
    }
}
