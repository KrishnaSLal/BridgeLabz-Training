package com.homenest;

class Thermostat extends Device {

    public Thermostat(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        energyUsage += 15;
        System.out.println("Thermostat ON");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Thermostat OFF");
    }

    @Override
    public void reset() {
        System.out.println("Thermostat reset: temperature calibrated");
    }
}
