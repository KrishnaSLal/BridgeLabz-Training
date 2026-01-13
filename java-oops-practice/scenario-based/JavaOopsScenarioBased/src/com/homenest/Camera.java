package com.homenest;

class Camera extends Device {

    public Camera(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        energyUsage += 10;
        System.out.println("Camera recording started");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Camera OFF");
    }

    @Override
    public void reset() {
        firmwareLog = "Camera firmware rebooted";
        System.out.println("Camera reset: memory cleared");
    }
}
