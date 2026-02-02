package com.tree.avltree.onlineticketbooking;

class Event {
    int eventID;
    String name;
    String location;
    int startTime; 
    Event left, right;

    Event(int eventID, String name, String location, int startTime) {
        this.eventID = eventID;
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        left = right = null;
    }
}
