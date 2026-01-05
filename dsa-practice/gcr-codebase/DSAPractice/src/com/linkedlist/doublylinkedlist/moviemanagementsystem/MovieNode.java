package com.linkedlist.doublylinkedlist.moviemanagementsystem;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;

    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
