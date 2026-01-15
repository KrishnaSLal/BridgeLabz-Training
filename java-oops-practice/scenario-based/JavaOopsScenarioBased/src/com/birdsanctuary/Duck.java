package com.birdsanctuary;

public class Duck extends Bird implements Flyable, Swimmable {

    public Duck(String name, String id) {
        super(name, "Duck", id);
    }

    public void eat() {
        System.out.println("Duck eats grains.");
    }

    public void fly() {
        System.out.println("Duck flies short distances.");
    }

    public void swim() {
        System.out.println("Duck swims gracefully.");
    }
}
