package com.petpal;

import java.util.Random;

public abstract class Pet implements IInteractable {

    protected String name;
    protected String type;
    protected int age;

    private int hunger; // 0 (full) to 100 (starving)
    private int mood;   // 0 (sad) to 100 (happy)
    private int energy; // 0 (tired) to 100 (full)

    private Random rand = new Random();

    // Constructor: random default pet
    public Pet(String type) {
        this.type = type;
        this.name = type + rand.nextInt(100);
        this.age = rand.nextInt(10) + 1;
        this.hunger = rand.nextInt(50);
        this.mood = rand.nextInt(50);
        this.energy = rand.nextInt(50);
    }

    // Constructor: user-specified pet
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.hunger = 50;
        this.mood = 50;
        this.energy = 50;
    }

    // Encapsulation: only accessible via methods
    public int getHunger() {
        return hunger;
    }

    public int getMood() {
        return mood;
    }

    public int getEnergy() {
        return energy;
    }

    // Interaction effects
    @Override
    public void feed() {
        hunger -= 20;  // decrease hunger
        if (hunger < 0) hunger = 0;
        mood += 5;     // increase mood slightly
        if (mood > 100) mood = 100;
        System.out.println(name + " has been fed. Hunger: " + hunger + ", Mood: " + mood);
    }

    @Override
    public void play() {
        energy -= 15;
        hunger += 10;
        mood += 20;
        if (energy < 0) energy = 0;
        if (hunger > 100) hunger = 100;
        if (mood > 100) mood = 100;
        System.out.println(name + " played and is happier! Mood: " + mood + ", Energy: " + energy);
    }

    @Override
    public void sleep() {
        energy += 25;
        hunger += 5;
        if (energy > 100) energy = 100;
        if (hunger > 100) hunger = 100;
        System.out.println(name + " is sleeping. Energy: " + energy + ", Hunger: " + hunger);
    }

    // Polymorphism: different pets make different sounds
    public abstract void makeSound();

    public void displayStatus() {
        System.out.println("\n--- " + name + " (" + type + ") Status ---");
        System.out.println("Age: " + age);
        System.out.println("Hunger: " + hunger);
        System.out.println("Mood: " + mood);
        System.out.println("Energy: " + energy);
    }
}
