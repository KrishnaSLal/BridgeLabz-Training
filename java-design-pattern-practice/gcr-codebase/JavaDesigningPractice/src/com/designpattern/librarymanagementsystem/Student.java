package com.designpattern.librarymanagementsystem;

public class Student implements User{
	private String name;
	
	public Student(String name) {
		this.name = name;
		showRole();
	}
	
	public void showRole() {
		System.out.println(name + " is a Student");
		
	}
	public void update(String msg) {
		System.out.println(name + " notified: "+msg);
		
	}
	
}