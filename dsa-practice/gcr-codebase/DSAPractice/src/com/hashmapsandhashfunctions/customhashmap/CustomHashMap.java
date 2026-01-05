package com.hashmapsandhashfunctions.customhashmap;

public class CustomHashMap {

    private int capacity;
    private HashNode[] buckets;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        buckets = new HashNode[capacity];
    }

    // Hash function
    private int getBucketIndex(int key) {
        return key % capacity;
    }

    // Insert or Update
    public void put(int key, String value) {
        int index = getBucketIndex(key);
        HashNode head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode newNode = new HashNode(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // Retrieve
    public String get(int key) {
        int index = getBucketIndex(key);
        HashNode head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    // Remove
    public void remove(int key) {
        int index = getBucketIndex(key);
        HashNode head = buckets[index];
        HashNode prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                System.out.println("Key " + key + " removed.");
                return;
            }
            prev = head;
            head = head.next;
        }
        System.out.println("Key not found.");
    }

    // Display map
    public void display() {
        for (int i = 0; i < capacity; i++) {
            HashNode head = buckets[i];
            System.out.print("Bucket " + i + ": ");
            while (head != null) {
                System.out.print("[" + head.key + "=" + head.value + "] ");
                head = head.next;
            }
            System.out.println();
        }
    }
}
