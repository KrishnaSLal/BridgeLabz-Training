package com.encapsulationandpolymorphism.vehiclerentalsystem;

class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.05; // 5% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (5%)";
    }
}
