package com.homenest;

class Light extends Device {

    public Light(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        energyUsage += 5;
        System.out.println("Light ON");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Light OFF");
    }

    @Override
    public void reset() {
        energyUsage = 0;
        System.out.println("Light reset: brightness restored");
    }
}
