package com.tree.avltree.gamingapp;

import java.util.ArrayList;
import java.util.List;

class Player {
    int playerID;
    String name;
    int points;
    Player left, right;
    
    List<Player> sameScore; // For multiple players with same points

    Player(int playerID, String name, int points) {
        this.playerID = playerID;
        this.name = name;
        this.points = points;
        left = right = null;
        sameScore = new ArrayList<>();
        sameScore.add(this);
    }
}
