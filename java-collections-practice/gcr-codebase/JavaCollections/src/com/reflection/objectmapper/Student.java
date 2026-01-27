package com.reflection.objectmapper;

public class Student {

    private int id;
    private String name;
    private String course;

    public Student() {
    }

    public void display() {
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Course : " + course);
    }
}
