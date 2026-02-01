package com.interfaces.functionalinterface.temperaturealertsystem;

@FunctionalInterface
interface TemperatureCheck {
    boolean isAlert(double temperature);
}
