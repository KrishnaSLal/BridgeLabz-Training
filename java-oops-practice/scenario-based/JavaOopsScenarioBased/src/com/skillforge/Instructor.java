package com.skillforge;

class Instructor extends User {

    public Instructor(String name) {
        super(name);
    }

    public void uploadCourse(String courseTitle) {
        System.out.println("Instructor " + name + " uploaded course: " + courseTitle);
    }
}
