package com.encapsulationandpolymorphism.onlinefooddeliverysystem;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}
abstract class FoodItem {

    // Encapsulation: private fields
    private String itemName;
    protected double price;
    protected int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }

    // Encapsulation: controlled updates
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }
}
