package com.javacollectionframework.queue.reverseaqueue;

import java.util.*;

public class ReverseQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Input elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        // Reverse the queue
        reverseQueue(queue);

        // Output
        System.out.println("Reversed Queue:");
        System.out.println(queue);

        sc.close();
    }

    // Recursive method
    private static void reverseQueue(Queue<Integer> queue) {

        if (queue.isEmpty()) {
            return;
        }

        int front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }
}
