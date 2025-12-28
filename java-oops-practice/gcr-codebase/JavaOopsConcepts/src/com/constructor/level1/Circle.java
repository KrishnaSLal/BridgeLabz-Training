package com.constructor.level1;

public class Circle {

	    double radius;

	    // Default constructor
	    Circle() {
	        this(1.0);   // calls parameterized constructor
	    }

	    // Parameterized constructor
	    Circle(double radius) {
	        this.radius = radius;
	    }

	    void display() {
	        System.out.println("Radius: " + radius);
	    }

	    public static void main(String[] args) {

	        // Using default constructor
	        Circle c1 = new Circle();
	        c1.display();

	        // Using parameterized constructor
	        Circle c2 = new Circle(5.5);
	        c2.display();
	    }
	}

