package com.encapsulationandpolymorphism.vehiclerentalsystem;

class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (rentalRate * days) + 2000; // heavy vehicle surcharge
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.15; // 15% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (15%)";
    }
}
