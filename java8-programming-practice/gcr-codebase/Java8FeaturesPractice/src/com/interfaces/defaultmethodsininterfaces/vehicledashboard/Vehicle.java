package com.interfaces.defaultmethodsininterfaces.vehicledashboard;

interface Vehicle {

    // Common behavior
    void displaySpeed();

    // New feature for electric vehicles
    default void displayBatteryPercentage() {
        System.out.println("Battery information not available for this vehicle.");
    }
}

