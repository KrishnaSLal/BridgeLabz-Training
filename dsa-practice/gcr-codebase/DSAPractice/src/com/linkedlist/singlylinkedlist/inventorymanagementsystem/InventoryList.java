package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

class InventoryList {

    private ItemNode head = null;

    // Add at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode node = new ItemNode(id, name, qty, price);
        node.next = head;
        head = node;
    }

    // Add at end
    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode node = new ItemNode(id, name, qty, price);
        if (head == null) {
            head = node;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    // Add at position
    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }

        ItemNode node = new ItemNode(id, name, qty, price);
        node.next = temp.next;
        temp.next = node;
    }

    // Remove by Item ID
    public void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        ItemNode prev = head, curr = head.next;
        while (curr != null) {
            if (curr.itemId == id) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Item not found!");
    }

    // Update quantity
    public void updateQuantity(int id, int qty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = qty;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    // Search by ID
    public void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    // Search by Name
    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Item not found!");
    }

    // Total inventory value
    public void totalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value = " + total);
    }

    // Display inventory
    public void displayAll() {
        ItemNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(ItemNode i) {
        System.out.println("ID: " + i.itemId +
                ", Name: " + i.itemName +
                ", Qty: " + i.quantity +
                ", Price: " + i.price);
    }

    // Merge sort entry
    public void sort(int choice, boolean asc) {
        head = mergeSort(head, choice, asc);
    }

    private ItemNode mergeSort(ItemNode node, int choice, boolean asc) {
        if (node == null || node.next == null)
            return node;

        ItemNode mid = getMiddle(node);
        ItemNode next = mid.next;
        mid.next = null;

        ItemNode left = mergeSort(node, choice, asc);
        ItemNode right = mergeSort(next, choice, asc);

        return merge(left, right, choice, asc);
    }

    private ItemNode merge(ItemNode a, ItemNode b, int choice, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (choice == 1) // Name
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                            : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        else // Price
            condition = asc ? a.price <= b.price : a.price > b.price;

        if (condition) {
            a.next = merge(a.next, b, choice, asc);
            return a;
        } else {
            b.next = merge(a, b.next, choice, asc);
            return b;
        }
    }

    private ItemNode getMiddle(ItemNode node) {
        ItemNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
