package com.student.model;

import org.springframework.beans.factory.annotation.Autowired;
import com.student.service.StudentService;

public class Address {
	
	private String city;
	private String state;
	
	public Address() {
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	public void setState(String state) {
		this.state=state;
	}
	
	public void displayAddress() {
		
		System.out.println(city + ", " + state);
		
//		studentService.showService();
	}

}