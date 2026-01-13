package com.gamebox;

abstract class Game implements IDownloadable {

    private String title;
    private String genre;
    protected double price;
    private double rating;

    public Game(String title, String genre, double price, double rating) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    // Operator logic
    public void applyOffer(double discount) {
        price -= discount;
        if (price < 0) price = 0;
    }

    @Override
    public void download() {
        System.out.println(title + " downloaded successfully.");
    }

    // 🔑 THIS LINE FIXES YOUR ERROR
    public abstract void playDemo();
}
