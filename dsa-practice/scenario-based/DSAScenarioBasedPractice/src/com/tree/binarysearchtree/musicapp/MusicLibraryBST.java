package com.tree.binarysearchtree.musicapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MusicLibraryBST {

    Track root;

    //Scenario 2: Insert new track
    void insert(int trackID, String title, String artist) {
        root = insertRec(root, trackID, title, artist);
    }

    Track insertRec(Track root, int trackID, String title, String artist) {
        if (root == null)
            return new Track(trackID, title, artist);

        if (trackID < root.trackID)
            root.left = insertRec(root.left, trackID, title, artist);
        else if (trackID > root.trackID)
            root.right = insertRec(root.right, trackID, title, artist);

        return root;
    }

    //Scenario 1: Search track by ID
    Track search(int trackID) {
        return searchRec(root, trackID);
    }

    Track searchRec(Track root, int trackID) {
        if (root == null || root.trackID == trackID)
            return root;
        return trackID < root.trackID
                ? searchRec(root.left, trackID)
                : searchRec(root.right, trackID);
    }

    //Show playlist alphabetically
    void displayAlphabetically() {
        if (root == null) {
            System.out.println("Music library is empty.");
            return;
        }

        ArrayList<Track> tracks = new ArrayList<>();
        inorderCollect(root, tracks);

        // Sort by title alphabetically
        Collections.sort(tracks, Comparator.comparing(t -> t.title));

        System.out.println("\n--- Playlist (Alphabetical) ---");
        for (Track t : tracks)
            System.out.println("Track ID: " + t.trackID + ", Title: " + t.title + ", Artist: " + t.artist);
    }

    // Collect tracks in a list
    void inorderCollect(Track root, ArrayList<Track> tracks) {
        if (root != null) {
            inorderCollect(root.left, tracks);
            tracks.add(root);
            inorderCollect(root.right, tracks);
        }
    }
}
