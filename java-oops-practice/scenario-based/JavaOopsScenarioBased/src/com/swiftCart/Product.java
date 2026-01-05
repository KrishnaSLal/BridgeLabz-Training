package com.swiftCart;

public abstract class Product {
    protected String name;
    protected double price;
    protected String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Polymorphic discount
    public abstract double getDiscount();

    protected double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
