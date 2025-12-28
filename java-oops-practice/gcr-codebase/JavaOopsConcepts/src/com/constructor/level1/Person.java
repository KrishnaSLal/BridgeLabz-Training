package com.constructor.level1;

public class Person {

	 String name;
	    int age;

	    // Parameterized constructor
	    Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    // Copy constructor
	    Person(Person other) {
	        this.name = other.name;
	        this.age = other.age;
	    }

	    void display() {
	        System.out.println("Name: " + name + ", Age: " + age);
	    }

	    public static void main(String[] args) {
	        Person p1 = new Person("Krishna S Lal", 22);

	        // Creating a copy of p1
	        Person p2 = new Person(p1);

	        p1.display();
	        p2.display();
	    }
}
