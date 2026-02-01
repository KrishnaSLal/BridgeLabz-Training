package com.interfaces.implementinginterfaces.rentalsystem;

public class Bike implements RentalVehicle {

	@Override
	public void rent() {
		System.out.println("Bike rented");
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Bike returned");
	}
}
