package com.encapsulationandpolymorphism.ridehailing;

public class Auto extends Vehicle implements GPS {

    private String location = "Unknown";

    public Auto(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // small fixed charge
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Auto Location: " + location);
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}
