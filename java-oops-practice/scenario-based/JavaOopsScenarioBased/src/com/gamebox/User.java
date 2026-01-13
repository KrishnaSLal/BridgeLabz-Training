package com.gamebox;

import java.util.ArrayList;

class User {
    private String username;
    private ArrayList<Game> ownedGames;

    public User(String username) {
        this.username = username;
        this.ownedGames = new ArrayList<>();
    }

    public void buyGame(Game game) {
        ownedGames.add(game);
        System.out.println(game.getTitle() + " added to your library.");
    }

    public void showOwnedGames() {
        if (ownedGames.isEmpty()) {
            System.out.println("No games owned.");
            return;
        }
        for (Game g : ownedGames) {
            System.out.println("- " + g.getTitle());
        }
    }
}
