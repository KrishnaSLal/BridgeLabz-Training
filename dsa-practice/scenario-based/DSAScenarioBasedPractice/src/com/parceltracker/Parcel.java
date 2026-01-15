package com.parceltracker;

public class Parcel {

    private Stage head;

    // Create default delivery chain
    public Parcel() {
        head = new Stage("Packed");
        Stage shipped = new Stage("Shipped");
        Stage inTransit = new Stage("In Transit");
        Stage delivered = new Stage("Delivered");

        head.next = shipped;
        shipped.next = inTransit;
        inTransit.next = delivered;
    }

    // Add custom checkpoint after a given stage
    public void addCheckpoint(String afterStage, String newStage) {
        Stage temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(afterStage)) {
                Stage checkpoint = new Stage(newStage);
                checkpoint.next = temp.next;
                temp.next = checkpoint;
                System.out.println("Checkpoint added: " + newStage);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Stage not found!");
    }

    // Forward tracking
    public void trackParcel() {
        if (head == null) {
            System.out.println("Parcel missing or lost!");
            return;
        }

        Stage temp = head;
        System.out.print("Parcel Status: ");

        while (temp != null) {
            System.out.print(temp.name);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Simulate lost parcel (null pointer handling)
    public void markLost() {
        head = null;
        System.out.println("Parcel marked as lost!");
    }
}
