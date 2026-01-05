package com.vehiclerentalapplication;

class Car extends Vehicle {

    public Car(int id, String brand) {
        super(id, brand, 800);
    }

    @Override
    public double calculateRent(int days) {
        double insurance = 200;
        return (baseRate * days) + insurance;
    }
}
