package com.fitnesstracker;

public class UserSteps {

	String name;
	private int step;
	
	public UserSteps(String name, int step) {
		this.name = name;
		this.step = step;
	}
	public int getStep() {
		return step;
	}
}