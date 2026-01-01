package com.inheritance.multilevelinheritance.educationalcoursehierarchy;

public class MainCourse {
	public static void main(String[] args) {

        Course c1 = new Course("Java Basics", 40);
        Course c2 = new OnlineCourse("OOPS with Java", 50,
                                     "Coursera", true);
        Course c3 = new PaidOnlineCourse("Advanced Java", 60,
                                         "Udemy", true,
                                         5000, 20);

        c1.displayCourseDetails();
        System.out.println();

        c2.displayCourseDetails();
        System.out.println();

        c3.displayCourseDetails();
    }
}
