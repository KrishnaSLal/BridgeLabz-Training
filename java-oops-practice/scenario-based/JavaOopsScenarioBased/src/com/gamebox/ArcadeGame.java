package com.gamebox;

class ArcadeGame extends Game {

    public ArcadeGame(String title, double price, double rating) {
        super(title, "Arcade", price, rating);
    }

    @Override
    public void playDemo() {
        System.out.println("Arcade Demo: Fast-paced 2-minute gameplay!");
    }
}
