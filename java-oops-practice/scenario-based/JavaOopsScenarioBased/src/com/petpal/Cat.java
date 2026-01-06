package com.petpal;

public class Cat extends Pet {

    public Cat() {
        super("Cat");
    }

    public Cat(String name, int age) {
        super(name, "Cat", age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}
