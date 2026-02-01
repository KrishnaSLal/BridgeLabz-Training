package com.csvdatahandling.advancedproblems.csvdatatojavaobjects;

class Student {
    int id;
    String name;
    int age;
    double marks;

    Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{id=" + id +", name='" + name + '\'' +", age=" + age +", marks=" + marks + '}';
    }
}
