package com.encapsulationandpolymorphism.vehiclerentalsystem;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
abstract class Vehicle {

    // Encapsulation: private fields
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    // Sensitive detail (encapsulated)
    private String insurancePolicyNumber;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Concrete method
    public void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per day: ₹" + rentalRate);
    }

    // Encapsulation for sensitive data
    public void setInsurancePolicyNumber(String policyNumber) {
        if (policyNumber != null && !policyNumber.isEmpty()) {
            this.insurancePolicyNumber = policyNumber;
        }
    }

    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }
}

