package com.json.javaobjecttojson;

public class Car {
    private int id;
    private String brand;
    private String model;
    private double price;

    public Car(int id, String brand, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Getters
    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
}
