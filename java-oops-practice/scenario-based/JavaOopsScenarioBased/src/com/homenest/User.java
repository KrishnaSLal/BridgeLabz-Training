package com.homenest;

import java.util.ArrayList;

class User {
	
    private String name;
    private ArrayList<Device> devices;

    public User(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }

    public void registerDevice(Device device) {
        devices.add(device);
        System.out.println(device.getDeviceId() + " registered successfully");
    }

    // 🔧 THIS METHOD WAS MISSING
    public Device getDevice(int index) {
        return devices.get(index);
    }

    public void showDevices() {
        if (devices.isEmpty()) {
            System.out.println("No devices registered.");
            return;
        }

        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + ". " + devices.get(i).getDeviceId() +
                    " | Status: " + (devices.get(i).isOn() ? "ON" : "OFF"));
        }
    }
}
