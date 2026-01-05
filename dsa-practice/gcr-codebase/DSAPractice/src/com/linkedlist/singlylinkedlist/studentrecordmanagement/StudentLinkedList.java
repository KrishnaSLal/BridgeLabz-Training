package com.linkedlist.singlylinkedlist.studentrecordmanagement;

class StudentLinkedList {

    private StudentNode head;

    // Add at beginning
    public void addAtBeginning(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Add at specific position
    public void addAtPosition(int roll, String name, int age, char grade, int position) {
        if (position == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(roll, name, age, grade);
        StudentNode temp = head;

        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by roll number
    public void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.rollNo == roll) {
            head = head.next;
            System.out.println("Student record deleted.");
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNo != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student record deleted.");
        }
    }

    // Search by roll number
    public void searchByRoll(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == roll) {
                System.out.println("Record Found:");
                displayStudent(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found!");
    }

    // Update grade
    public void updateGrade(int roll, char newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found!");
    }

    // Display all records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        StudentNode temp = head;
        System.out.println("RollNo  Name  Age  Grade");
        while (temp != null) {
            displayStudent(temp);
            temp = temp.next;
        }
    }

    private void displayStudent(StudentNode s) {
        System.out.println(s.rollNo + "   " + s.name + "   " + s.age + "   " + s.grade);
    }
}
