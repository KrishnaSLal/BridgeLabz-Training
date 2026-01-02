package com.encapsulationandpolymorphism.ecommerceplatform;

class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return price * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applied";
    }
}
