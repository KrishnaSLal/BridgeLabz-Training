package com.fleetmanager;

public class DepotList {

    private String vehicleId;
    private int mileage;

    public DepotList(String vehicleId, int mileage) {
        this.vehicleId = vehicleId;
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return vehicleId + " | Mileage: " + mileage + " km";
    }
}