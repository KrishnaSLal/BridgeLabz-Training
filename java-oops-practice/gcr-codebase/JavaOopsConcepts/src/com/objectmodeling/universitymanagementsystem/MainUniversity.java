package com.objectmodeling.universitymanagementsystem;

public class MainUniversity {
	public static void main(String[] args) {

        Student s1 = new Student("Amit");
        Student s2 = new Student("Neha");

        Professor p1 = new Professor("Dr. Sharma");

        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s1.enrollCourse(c2);

        p1.assignCourse(c1);
        p1.assignCourse(c2);

        System.out.println();
        c1.showCourseDetails();
        System.out.println();
        c2.showCourseDetails();
    }
}
