package com.homenest;

abstract class Device implements IControllable {
    private String deviceId;
    private boolean status;              // Encapsulated
    protected double energyUsage;        // Accessible to subclasses
    protected String firmwareLog;         // Secured firmware logs

    // Constructor
    public Device(String deviceId) {
        this.deviceId = deviceId;
        this.status = false;
        this.energyUsage = 0.0;
        this.firmwareLog = "Firmware v1.0 installed";
    }

    // Encapsulation: No direct setter for status
    public boolean isOn() {
        return status;
    }

    protected void setStatus(boolean status) {
        this.status = status;
    }

    public String getDeviceId() {
        return deviceId;
    }

    // Simulated operator overloading (energy calculation)
    public double addEnergy(double usage) {
        return this.energyUsage + usage;
    }

    // Abstract method for polymorphism
    public abstract void reset();
}
