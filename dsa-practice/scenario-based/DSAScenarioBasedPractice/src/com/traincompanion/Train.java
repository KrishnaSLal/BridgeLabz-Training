package com.traincompanion;

public class Train {

    private Compartment head;
    private Compartment tail;

    // Insert compartment at end
    public void addCompartment(String name, String service) {
        Compartment newCompartment = new Compartment(name, service);

        if (head == null) {
            head = tail = newCompartment;
        } else {
            tail.next = newCompartment;
            newCompartment.prev = tail;
            tail = newCompartment;
        }
    }

    // Remove a compartment by name
    public void removeCompartment(String name) {
        Compartment temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {

                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Compartment removed: " + name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Compartment not found!");
    }

    // Traverse forward
    public void traverseForward() {
        Compartment temp = head;
        System.out.println("Forward Traversal:");
        while (temp != null) {
            System.out.println(temp.name + " - Service: " + temp.service);
            temp = temp.next;
        }
    }

    // Traverse backward
    public void traverseBackward() {
        Compartment temp = tail;
        System.out.println("Backward Traversal:");
        while (temp != null) {
            System.out.println(temp.name + " - Service: " + temp.service);
            temp = temp.prev;
        }
    }

    // Display adjacent compartments
    public void showAdjacent(String name) {
        Compartment temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {

                System.out.println("Current: " + temp.name);

                if (temp.prev != null)
                    System.out.println("Previous: " + temp.prev.name);

                if (temp.next != null)
                    System.out.println("Next: " + temp.next.name);

                return;
            }
            temp = temp.next;
        }
        System.out.println("Compartment not found!");
    }
}
