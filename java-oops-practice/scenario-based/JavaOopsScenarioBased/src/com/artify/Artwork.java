package com.artify;

abstract class Artwork implements IPurchasable {

    protected String title;
    protected String artist;
    protected double price;
    protected String licenseType;    // protected → encapsulation
    protected boolean hasPreview;

    // Constructor without preview
    public Artwork(String title, String artist, double price, String licenseType) {
        this(title, artist, price, licenseType, false);
    }

    // Constructor with preview
    public Artwork(
            String title,
            String artist,
            double price,
            String licenseType,
            boolean hasPreview
    ) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.licenseType = licenseType;
        this.hasPreview = hasPreview;
    }

    @Override
    public void purchase(User user) {

        if (user.getWalletBalance() >= price) {
            user.deductAmount(price);
            System.out.println(user.getName() + " purchased \"" + title + "\"");
        } else {
            System.out.println("Insufficient wallet balance.");
        }
    }
}
