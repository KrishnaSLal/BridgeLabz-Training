package com.encapsulationandpolymorphism.ecommerceplatform;

class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return price * 0.05; // 5% tax
    }

    @Override
    public String getTaxDetails() {
        return "5% Clothing Tax applied";
    }
}
