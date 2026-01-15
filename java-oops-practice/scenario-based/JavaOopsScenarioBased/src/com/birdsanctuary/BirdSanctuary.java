package com.birdsanctuary;

import java.util.ArrayList;

public class BirdSanctuary {

    private ArrayList<Bird> birds = new ArrayList<>();

    public void addBird(Bird bird) {
        birds.add(bird);
    }

    public void displayAll() {
        for (Bird b : birds) {
            System.out.println(b.getInfo());
            b.eat();
            if (b instanceof Flyable) ((Flyable) b).fly();
            if (b instanceof Swimmable) ((Swimmable) b).swim();
            System.out.println("----------------");
        }
    }

    public void removeById(String id) {
        birds.removeIf(b -> b.getId().equals(id));
    }

    public void report() {
        int fly = 0, swim = 0, both = 0, neither = 0;

        for (Bird b : birds) {
            boolean f = b instanceof Flyable;
            boolean s = b instanceof Swimmable;

            if (f && s) both++;
            else if (f) fly++;
            else if (s) swim++;
            else neither++;
        }

        System.out.println("📊 Sanctuary Report");
        System.out.println("Flyable: " + fly);
        System.out.println("Swimmable: " + swim);
        System.out.println("Both: " + both);
        System.out.println("Neither: " + neither);
    }

    public ArrayList<Bird> getBirds() {
        return birds;
    }
}
