package com.smartshelf;

public class Book {
    
	String name;
	
	Book(String name){
		this.name = name;
	}
	
	void display() {
		System.out.println(name);
	}
}
