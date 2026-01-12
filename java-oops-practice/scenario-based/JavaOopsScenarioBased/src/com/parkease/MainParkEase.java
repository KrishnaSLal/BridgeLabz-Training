package com.parkease;

public class MainParkEase {

    public static void main(String[] args) {

        ParkingSlot carSlot = new ParkingSlot(1, "Basement A", "Car");
        Vehicle car = new Car("TN10AB1234");

        ParkingManager manager = new ParkingManager();

        manager.parkVehicle(carSlot, car);
        manager.showLogs();

        manager.releaseVehicle(carSlot, car, 6);
        manager.showLogs();
    }
}
