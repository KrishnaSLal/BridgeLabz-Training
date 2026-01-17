package com.cinemahouse;

public class MovieShow {

    private String movieName;
    private int showTime;

    public MovieShow(String movieName, int showTime) {
        this.movieName = movieName;
        this.showTime = showTime;
    }

    public int getShowTime() {
        return showTime;
    }

    @Override
    public String toString() {
        return "Movie: " + movieName +
               ", Show Time: " + showTime;
    }
}
