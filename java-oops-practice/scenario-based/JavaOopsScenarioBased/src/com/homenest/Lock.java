package com.homenest;

class Lock extends Device {

    public Lock(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Door locked");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Door unlocked");
    }

    @Override
    public void reset() {
        System.out.println("Lock reset: security codes refreshed");
    }
}
