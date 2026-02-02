package com.tree.binarysearchtree.musicapp;

class Track {
    int trackID;
    String title;
    String artist;
    Track left, right;

    Track(int trackID, String title, String artist) {
        this.trackID = trackID;
        this.title = title;
        this.artist = artist;
        left = right = null;
    }
}
