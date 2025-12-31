package com.objectmodeling.schoolandstudents;

public class MainSchool {

    public static void main(String[] args) {

        School school = new School("Green Valley School");

        Student s1 = new Student("Ravi");
        Student s2 = new Student("Anita");

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");

        school.addStudent(s1);
        school.addStudent(s2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c2);

        school.showStudents();
        System.out.println();

        s1.viewCourses();
        System.out.println();

        c2.showEnrolledStudents();
    }
}
