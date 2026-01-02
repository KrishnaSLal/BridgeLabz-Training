package com.encapsulationandpolymorphism.vehiclerentalsystem;

class Car extends Vehicle implements Insurable {

    public Car(String number, double rate) {
        super(number, "Car", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.10; // 10% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (10%)";
    }
}
