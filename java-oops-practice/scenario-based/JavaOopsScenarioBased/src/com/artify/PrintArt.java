package com.artify;

class PrintArt extends Artwork {

    public PrintArt(
            String title,
            String artist,
            double price,
            String licenseType
    ) {
        super(title, artist, price, licenseType);
    }

    @Override
    public void license(User user) {
        System.out.println(
                "Print Art License Applied: " + licenseType +
                " (Limited physical reproductions allowed)"
        );
    }
}
