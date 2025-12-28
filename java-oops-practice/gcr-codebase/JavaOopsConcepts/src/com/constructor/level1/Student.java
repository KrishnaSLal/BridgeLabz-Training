package com.constructor.level1;

public class Student {

    public int rollNumber;
    protected String name;
    private double cgpa;

    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public double getCGPA() {
        return cgpa;
    }

    public void setCGPA(double cgpa) {
        if (cgpa >= 0 && cgpa <= 10) {
            this.cgpa = cgpa;
        }
    }

    // ✅ MAIN METHOD IS HERE NOW
    public static void main(String[] args) {

        PostgraduateStudent pg =
                new PostgraduateStudent(101, "Krishna", 8.5, "Computer Science");

        pg.displayDetails();

        pg.setCGPA(9.2);
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}

// Subclass
class PostgraduateStudent extends Student {

    private String specialization;

    public PostgraduateStudent(int rollNumber, String name,
                               double cgpa, String specialization) {
        super(rollNumber, name, cgpa);
        this.specialization = specialization;
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);      // protected
        System.out.println("CGPA: " + getCGPA()); // private via method
        System.out.println("Specialization: " + specialization);
    }
}
