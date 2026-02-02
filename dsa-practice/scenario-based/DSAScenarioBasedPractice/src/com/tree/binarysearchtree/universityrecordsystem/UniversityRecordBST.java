package com.tree.binarysearchtree.universityrecordsystem;

class UniversityRecordBST {

    Student root;

    // 🔹 Scenario 1: Insert student record
    void insert(int rollNo, String name) {
        root = insertRec(root, rollNo, name);
    }

    Student insertRec(Student root, int rollNo, String name) {
        if (root == null) {
            return new Student(rollNo, name);
        }

        if (rollNo < root.rollNo) {
            root.left = insertRec(root.left, rollNo, name);
        } else if (rollNo > root.rollNo) {
            root.right = insertRec(root.right, rollNo, name);
        }

        return root;
    }

    // 🔹 Scenario 2: Delete student record
    void delete(int rollNo) {
        root = deleteRec(root, rollNo);
    }

    Student deleteRec(Student root, int rollNo) {
        if (root == null) return null;

        if (rollNo < root.rollNo) {
            root.left = deleteRec(root.left, rollNo);
        } else if (rollNo > root.rollNo) {
            root.right = deleteRec(root.right, rollNo);
        } else {
            // Node found
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Two children
            Student successor = minValue(root.right);
            root.rollNo = successor.rollNo;
            root.name = successor.name;
            root.right = deleteRec(root.right, successor.rollNo);
        }
        return root;
    }

    Student minValue(Student root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // Sorted roll numbers (Inorder traversal)
    void displayRecords() {
        System.out.println("Sorted Student Records:");
        inorder(root);
    }

    void inorder(Student root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Roll No: " + root.rollNo + ", Name: " + root.name);
            inorder(root.right);
        }
    }

    // Search student
    boolean search(int rollNo) {
        return searchRec(root, rollNo);
    }

    boolean searchRec(Student root, int rollNo) {
        if (root == null) return false;
        if (root.rollNo == rollNo) return true;

        return rollNo < root.rollNo
                ? searchRec(root.left, rollNo)
                : searchRec(root.right, rollNo);
    }
}
