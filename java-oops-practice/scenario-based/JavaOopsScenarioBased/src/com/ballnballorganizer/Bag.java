package com.ballnballorganizer;

import java.util.ArrayList;
import java.util.List;

public class Bag implements StorableBehaviour {

    private String id;
    private String color;
    private int capacity;
    private List<Balls> balls;

    public Bag(String id, String color, int capacity) {
        this.id = id;
        this.color = color;
        this.capacity = capacity;
        this.balls = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBallCount() {
        return balls.size();
    }

    // Add ball
    public void addBall(Balls ball) {
        if (balls.size() >= capacity) {
            System.out.println("Bag " + id + " is full. Cannot add ball " + ball.getId());
            return;
        }
        balls.add(ball);
        System.out.println("Ball added to Bag " + id);
    }

    // Remove ball
    public void removeBall(String ballId) {
        for (Balls ball : balls) {
            if (ball.getId().equals(ballId)) {
                balls.remove(ball);
                System.out.println("🗑️ Ball removed from Bag " + id);
                return;
            }
        }
        System.out.println("⚠️ Ball not found in Bag " + id);
    }

    // Display balls inside of bag
    public void displayBalls() {
        System.out.println("\nBalls in Bag " + id + ":");
        if (balls.isEmpty()) {
            System.out.println("No balls in this bag.");
            return;
        }
        for (Balls ball : balls) {
            System.out.println(ball);
        }
    }
}
