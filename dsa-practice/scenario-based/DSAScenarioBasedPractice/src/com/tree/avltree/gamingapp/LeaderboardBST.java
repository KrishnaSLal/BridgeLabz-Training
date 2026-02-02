package com.tree.avltree.gamingapp;

import java.util.ArrayList;
import java.util.List;

class LeaderboardBST {

    Player root;

    // Insert or update a player
    void insertOrUpdate(int playerID, String name, int points) {
        // First remove existing player if present
        remove(playerID);
        root = insertRec(root, new Player(playerID, name, points));
    }

    Player insertRec(Player root, Player newPlayer) {
        if (root == null) return newPlayer;

        if (newPlayer.points < root.points) {
            root.left = insertRec(root.left, newPlayer);
        } else if (newPlayer.points > root.points) {
            root.right = insertRec(root.right, newPlayer);
        } else {
            // same points → add to sameScore list
            root.sameScore.add(newPlayer);
        }
        return root;
    }

    // Remove player by ID
    void remove(int playerID) {
        root = removeRec(root, playerID);
    }

    Player removeRec(Player root, int playerID) {
        if (root == null) return null;

        // Check current node's sameScore list
        for (int i = 0; i < root.sameScore.size(); i++) {
            if (root.sameScore.get(i).playerID == playerID) {
                root.sameScore.remove(i);
                break;
            }
        }

        // If list empty, remove the node
        if (root.sameScore.isEmpty()) {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            Player successor = minValue(root.right);
            root.points = successor.points;
            root.sameScore = successor.sameScore;
            root.right = removeRec(root.right, successor.sameScore.get(0).playerID);
        } else {
            return root; // node still has players
        }

        // Recurse to children
        root.left = removeRec(root.left, playerID);
        root.right = removeRec(root.right, playerID);

        return root;
    }

    Player minValue(Player node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Display top N players
    void displayTop(int n) {
        List<Player> result = new ArrayList<>();
        reverseInorder(root, result, n);
        System.out.println("\n--- Top " + n + " Players ---");
        for (Player p : result) {
            System.out.println("ID: " + p.playerID + ", Name: " + p.name + ", Points: " + p.points);
        }
    }

    void reverseInorder(Player root, List<Player> result, int n) {
        if (root == null || result.size() >= n) return;

        reverseInorder(root.right, result, n);

        for (Player p : root.sameScore) {
            if (result.size() >= n) break;
            result.add(p);
        }

        reverseInorder(root.left, result, n);
    }
}
