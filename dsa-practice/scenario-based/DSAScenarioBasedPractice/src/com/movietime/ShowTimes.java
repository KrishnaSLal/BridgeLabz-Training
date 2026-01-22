package com.movietime;

import java.time.LocalTime;

public class ShowTimes {

	private String name;
	private LocalTime time;
	
	public ShowTimes(String name, LocalTime time) {
		
		this.name = name;
		this.time = time;
		
	}
	public LocalTime getTime() {
		return time;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Show: "+ name +"\nTime: " + time + "\n-------------------------------";
	}
}
