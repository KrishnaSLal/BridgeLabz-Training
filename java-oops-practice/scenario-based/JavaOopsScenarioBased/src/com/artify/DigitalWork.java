package com.artify;

class DigitalArt extends Artwork {

    public DigitalArt(
            String title,
            String artist,
            double price,
            String licenseType,
            boolean hasPreview
    ) {
        super(title, artist, price, licenseType, hasPreview);
    }

    @Override
    public void license(User user) {
        System.out.println(
                "Digital Art License Applied: " + licenseType +
                " (Non-transferable, single-device use)"
        );
    }
}
