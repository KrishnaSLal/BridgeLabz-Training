package com.birdsanctuary;

public class Penguin extends Bird implements Swimmable {

    public Penguin(String name, String id) {
        super(name, "Penguin", id);
    }

    public void eat() {
        System.out.println("Penguin eats fish.");
    }

    public void swim() {
        System.out.println("Penguin swims fast underwater.");
    }
}
