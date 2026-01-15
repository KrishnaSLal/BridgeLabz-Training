package com.birdsanctuary;

public class Eagle extends Bird implements Flyable {

    public Eagle(String name, String id) {
        super(name, "Eagle", id);
    }

    public void eat() {
        System.out.println("Eagle eats meat.");
    }

    public void fly() {
        System.out.println("Eagle soars high.");
    }
}
