package com.stacksandqueues.implementqueue;

import java.util.Stack;
import java.util.NoSuchElementException;

class QueueUsingStacks<T> {
    private Stack<T> stackEnqueue;
    private Stack<T> stackDequeue;

    public QueueUsingStacks() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(T item) {
        stackEnqueue.push(item);
        System.out.println(item + " enqueued.");
    }

    // Dequeue operation
    public T dequeue() {
        if(stackDequeue.isEmpty()) {
            if(stackEnqueue.isEmpty()) throw new NoSuchElementException("Queue is empty.");
            while(!stackEnqueue.isEmpty()) stackDequeue.push(stackEnqueue.pop());
        }
        return stackDequeue.pop();
    }

    // Peek front element
    public T peek() {
        if(stackDequeue.isEmpty()) {
            if(stackEnqueue.isEmpty()) throw new NoSuchElementException("Queue is empty.");
            while(!stackEnqueue.isEmpty()) stackDequeue.push(stackEnqueue.pop());
        }
        return stackDequeue.peek();
    }

    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    public int size() {
        return stackEnqueue.size() + stackDequeue.size();
    }
}
