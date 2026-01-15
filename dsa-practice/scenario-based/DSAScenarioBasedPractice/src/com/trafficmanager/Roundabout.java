package com.trafficmanager;

public class Roundabout {

    private Vehicle tail = null;

    // Add vehicle to roundabout
    public void addVehicle(String number) {
        Vehicle newVehicle = new Vehicle(number);

        if (tail == null) {
            tail = newVehicle;
            tail.next = tail;
        } else {
            newVehicle.next = tail.next;
            tail.next = newVehicle;
            tail = newVehicle;
        }
        System.out.println("Vehicle entered roundabout: " + number);
    }

    // Remove vehicle from roundabout
    public void removeVehicle() {
        if (tail == null) {
            System.out.println("Roundabout is empty!");
            return;
        }

        Vehicle head = tail.next;

        if (head == tail) {
            System.out.println("Vehicle exited: " + head.number);
            tail = null;
        } else {
            System.out.println("Vehicle exited: " + head.number);
            tail.next = head.next;
        }
    }

    // Print roundabout state
    public void display() {
        if (tail == null) {
            System.out.println("Roundabout is empty!");
            return;
        }

        Vehicle temp = tail.next;
        System.out.print("Roundabout: ");

        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println("(back to start)");
    }

    public boolean isEmpty() {
        return tail == null;
    }
}
