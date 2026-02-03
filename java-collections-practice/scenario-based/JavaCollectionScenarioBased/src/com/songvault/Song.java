package com.songvault;

public class Song implements Media {

    private String title;
    private String artist;
    private String duration;
    private String genre;

    public Song(String title, String artist, String duration, String genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " | " + artist + " | " + duration;
    }
}
