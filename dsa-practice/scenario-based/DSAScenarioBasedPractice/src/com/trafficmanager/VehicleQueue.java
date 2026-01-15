package com.trafficmanager;

import java.util.LinkedList;
import java.util.Queue;

public class VehicleQueue {

    private Queue<String> queue = new LinkedList<>();
    private int capacity;

    public VehicleQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(String number) {
        if (queue.size() == capacity) {
            System.out.println("Queue Overflow! Vehicle waiting area full.");
            return;
        }
        queue.add(number);
        System.out.println("Vehicle added to waiting queue: " + number);
    }

    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
