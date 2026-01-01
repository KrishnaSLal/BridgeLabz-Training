package com.inheritance.singleinheritance.smarthomedevice;

class Device {

    String deviceId;
    String status;   // ON / OFF

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
