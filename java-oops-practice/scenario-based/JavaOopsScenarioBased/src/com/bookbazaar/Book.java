package com.bookbazaar;

public abstract class Book implements IDiscountable {

    private String title;
    private String author;
    protected double price;
    private int stock;

    // Constructor
    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    // Getters (Encapsulation)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Inventory update through method only
    public void reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            System.out.println("Not enough stock for " + title);
        }
    }

    // Abstract method for polymorphism
    public abstract double applyDiscount(double price, int quantity);
}
