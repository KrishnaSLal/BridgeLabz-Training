package com.ballnballorganizer;
public class Balls implements StorableBehaviour {

    private String id;
    private String color;
    private String size; 

    public Balls(String id, String color, String size) {
        this.id = id;
        this.color = color;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Ball [ID=" + id + ", Color=" + color + ", Size=" + size + "]";
    }
}
