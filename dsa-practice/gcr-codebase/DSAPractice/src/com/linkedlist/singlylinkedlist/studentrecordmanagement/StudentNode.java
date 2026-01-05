package com.linkedlist.singlylinkedlist.studentrecordmanagement;

class StudentNode {
    int rollNo;
    String name;
    int age;
    char grade;
    StudentNode next;

    StudentNode(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

