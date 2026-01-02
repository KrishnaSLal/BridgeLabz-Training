package com.encapsulationandpolymorphism.ridehailing;

public class Bike extends Vehicle implements GPS {

    private String location = "Unknown";

    public Bike(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // no base charge
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Bike Location: " + location);
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}
