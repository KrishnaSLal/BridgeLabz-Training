package com.objectmodeling.university;

public class MainUniversity {

    public static void main(String[] args) {

        University university = new University("Tech University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        Faculty f1 = new Faculty("Dr. Sharma");
        Faculty f2 = new Faculty("Dr. Mehta");

        university.addFaculty(f1);
        university.addFaculty(f2);

        university.showDepartments();
        university.showFaculties();

        System.out.println();

        university.deleteUniversity();

        university.showDepartments();

        System.out.println();
        System.out.println("Faculty still exists independently:");
        System.out.println(f1.getFacultyName());
        System.out.println(f2.getFacultyName());
    }
}
