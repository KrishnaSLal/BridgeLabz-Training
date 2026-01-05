package com.linkedlist.doublylinkedlist.undoredofunctionality;

class TextEditor {
    private TextState head;      // first state
    private TextState tail;      // last state
    private TextState current;   // current state
    private final int maxHistory; // limit history size
    private int size;            // current number of states

    public TextEditor(int maxHistory) {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.maxHistory = maxHistory;
        this.size = 0;
    }

    // Add a new state (typing or command)
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If we undid some steps and add a new state, remove redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = getSizeFromHead();
        }

        // Add new state at the end
        if (head == null) {
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }

        current = tail;
        size++;

        // Limit history
        while (size > maxHistory) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo: move to previous state
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Redo: move to next state
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    // Display current state
    public void displayCurrent() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }

    // Helper to count size from head to tail
    private int getSizeFromHead() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
