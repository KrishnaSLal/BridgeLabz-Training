package com.birdsanctuary;

public class Kiwi extends Bird {

    public Kiwi(String name, String id) {
        super(name, "Kiwi", id);
    }

    public void eat() {
        System.out.println("Kiwi eats insects.");
    }
}
