package com.tree.avltree.onlineticketbooking;

class TicketBookingBST {

    Event root;

    //Insert event
    void insert(int eventID, String name, String location, int startTime) {
        root = insertRec(root, new Event(eventID, name, location, startTime));
    }

    Event insertRec(Event root, Event newEvent) {
        if (root == null) return newEvent;

        if (newEvent.startTime < root.startTime)
            root.left = insertRec(root.left, newEvent);
        else if (newEvent.startTime > root.startTime)
            root.right = insertRec(root.right, newEvent);
        else
            System.out.println("Event at this time already exists!");

        return root;
    }

    //Cancel event
    void delete(int startTime) {
        root = deleteRec(root, startTime);
    }

    Event deleteRec(Event root, int startTime) {
        if (root == null) return null;

        if (startTime < root.startTime)
            root.left = deleteRec(root.left, startTime);
        else if (startTime > root.startTime)
            root.right = deleteRec(root.right, startTime);
        else {
            // Node found
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            Event successor = minValue(root.right);
            root.eventID = successor.eventID;
            root.name = successor.name;
            root.location = successor.location;
            root.startTime = successor.startTime;
            root.right = deleteRec(root.right, successor.startTime);
        }
        return root;
    }

    Event minValue(Event node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    //Show events in upcoming order
    void displayEvents() {
        if (root == null) {
            System.out.println("No events scheduled.");
            return;
        }
        inorder(root);
    }

    void inorder(Event root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Event ID: " + root.eventID + ", Name: " + root.name + 
                               ", Location: " + root.location + ", Time: " + root.startTime);
            inorder(root.right);
        }
    }
}
