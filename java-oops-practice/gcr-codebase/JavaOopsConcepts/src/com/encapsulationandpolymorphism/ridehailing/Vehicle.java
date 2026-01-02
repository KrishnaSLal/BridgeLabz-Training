package com.encapsulationandpolymorphism.ridehailing;

public interface GPS {
    void getCurrentLocation();
    void updateLocation(String newLocation);
}

public abstract class Vehicle {

    // Encapsulation: private fields
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor
    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate Per Km: ₹" + ratePerKm);
    }

    // Protected getter (used by subclasses)
    protected double getRatePerKm() {
        return ratePerKm;
    }
}
