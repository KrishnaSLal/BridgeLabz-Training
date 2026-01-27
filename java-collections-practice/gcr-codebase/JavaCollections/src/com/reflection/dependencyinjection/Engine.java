package com.reflection.dependencyinjection;

class Engine {
    public void start() {
        System.out.println("Engine started!");
    }
}

class Car {
    @Inject
    private Engine engine;   // Dependency to be injected

    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }
}
