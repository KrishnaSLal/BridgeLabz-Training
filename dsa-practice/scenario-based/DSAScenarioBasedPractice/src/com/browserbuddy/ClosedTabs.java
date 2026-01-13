package com.browserbuddy;

public class ClosedTabs {
	private BrowseHistoryNode current;

    // Visit new page
    public void visit(String url) {
        BrowseHistoryNode newNode = new BrowseHistoryNode(url);

        if (current != null) {
            current.next = null; // clear forward history
            newNode.prev = current;
            current.next = newNode;
        }

        current = newNode;
        System.out.println("Visited: " + url);
    }

    //To go back
    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    //To go forward
    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No forward page.");
        }
    }

    public String getCurrentPage() {
        return current != null ? current.url : "Empty Tab";
    }
}