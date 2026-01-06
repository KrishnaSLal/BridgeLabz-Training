package com.petpal;

public class Bird extends Pet {

    public Bird() {
        super("Bird");
    }

    public Bird(String name, int age) {
        super(name, "Bird", age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet Tweet!");
    }
}
