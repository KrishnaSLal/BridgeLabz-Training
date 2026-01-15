package com.parceltracker;

public class Stage {
    String name;
    Stage next;

    public Stage(String name) {
        this.name = name;
        this.next = null;
    }
}
