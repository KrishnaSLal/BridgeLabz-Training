package com.javacollectionframework.queue.stackusingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Add new element to q1
        q1.add(x);

        // Move everything back to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    // Pop operation
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }

    // Top operation
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
