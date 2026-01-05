package com.stacksandqueues.implementqueue;

public class MainQueue {
    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // 10
        System.out.println("Dequeued: " + queue.dequeue());   // 10

        queue.enqueue(40);
        System.out.println("Dequeued: " + queue.dequeue());   // 20
        System.out.println("Dequeued: " + queue.dequeue());   // 30
        System.out.println("Dequeued: " + queue.dequeue());   // 40

        System.out.println("Is queue empty? " + queue.isEmpty()); // true
    }
}
