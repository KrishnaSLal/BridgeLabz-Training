package com.interfaces.functionalinterface;

@FunctionalInterface
interface TemperatureCheck {
    boolean isAlert(double temperature);
}
