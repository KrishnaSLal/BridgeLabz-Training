package com.interfaces.implementinginterfaces;

public class AC implements SmartDevice {

	@Override
	public void turnOn() {
		System.out.println("AC turned on");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Ac turned off");
	}
}
