package com.encapsulationandpolymorphism.ridehailing;

public class Car extends Vehicle implements GPS {

    private String location = "Unknown";

    public Car(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // base charge
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Car Location: " + location);
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}
