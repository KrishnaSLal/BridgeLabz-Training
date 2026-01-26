package com.javacollectionframework.queue.cicularbuffersimulation;

public class CircularBufferSimulation {

    private int[] buffer;
    private int size;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public CircularBufferSimulation(int size) {
        this.size = size;
        buffer = new int[size];
    }

    // Insert element (overwrites if found full)
    public void enqueue(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;

        if (count < size) {
            count++;
        } else {
            // Buffer full - overwrite oldest
            front = (front + 1) % size;
        }
    }

    public void display() {
        if (count == 0) {
            System.out.println("Buffer is empty");
            return;
        }

        System.out.print("Buffer: [ ");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println("]");
    }
}
