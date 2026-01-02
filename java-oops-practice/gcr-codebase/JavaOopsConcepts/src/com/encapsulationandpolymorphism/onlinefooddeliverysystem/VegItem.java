package com.encapsulationandpolymorphism.onlinefooddeliverysystem;

class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "10% Veg Item Discount";
    }
}
