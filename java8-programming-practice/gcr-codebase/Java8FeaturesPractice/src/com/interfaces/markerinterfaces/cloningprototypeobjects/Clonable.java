package com.interfaces.markerinterfaces.cloningprototypeobjects;

class Product implements Cloneable {

    int id;
    String name;

    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "'}";
    }
}
