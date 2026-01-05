package com.cabbygo;

public class RideService implements IRideService {

    @Override
    public void bookRide(Vehicle vehicle, Driver driver, double distance) {
        double fare = vehicle.calculateFare(distance);

        System.out.println("\n🚕 Ride Booked Successfully!");
        System.out.println("Driver Name : " + driver.getName());
        System.out.println("Rating      : " + driver.getRating());
        System.out.println("Vehicle     : " + vehicle.getType());
        System.out.println("Distance    : " + distance + " km");
        System.out.println("Fare        : ₹" + fare);
    }

    @Override
    public void endRide() {
        System.out.println("\n✅ Ride Ended. Visit again!");
    }
}
