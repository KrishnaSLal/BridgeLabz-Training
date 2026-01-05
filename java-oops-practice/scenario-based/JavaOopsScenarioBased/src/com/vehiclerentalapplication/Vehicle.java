package com.vehiclerentalapplication;

abstract class Vehicle implements Rentable {
    protected int vehicleId;
    protected String brand;
    protected double baseRate;

    public Vehicle(int vehicleId, String brand, double baseRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void displayInfo() {
        System.out.println("Vehicle ID: " + vehicleId + ", Brand: " + brand);
    }
}
