package com.vehiclerentalapplication;

class Truck extends Vehicle {

    public Truck(int id, String brand) {
        super(id, brand, 1500);
    }

    @Override
    public double calculateRent(int days) {
        double loadingCharge = 500;
        return (baseRate * days) + loadingCharge;
    }
}
