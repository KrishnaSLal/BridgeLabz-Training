package com.annotations.override;

public class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Dog says: Woof Woof!");
    }
}
