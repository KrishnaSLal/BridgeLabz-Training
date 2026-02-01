package com.interfaces.implementinginterfaces;

public class Light implements SmartDevice {

	@Override
	public void turnOn() {
		System.out.println("Light is turned on");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Light is turned off");
	}
}
