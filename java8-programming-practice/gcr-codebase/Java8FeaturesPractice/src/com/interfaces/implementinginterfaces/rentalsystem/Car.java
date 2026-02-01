package com.interfaces.implementinginterfaces.rentalsystem;

public class Car implements RentalVehicle {

	@Override
	public void rent() {
		System.out.println("Car rented");
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Car returned");
	}
}
