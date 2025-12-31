package com.objectmodeling.universitymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Professor {

    private String professorName;
    private List<Course> courses;

    public Professor(String professorName) {
        this.professorName = professorName;
        this.courses = new ArrayList<>();
    }

    public String getProfessorName() {
        return professorName;
    }

    public void assignCourse(Course course) {
        courses.add(course);
        course.assignProfessor(this);
        System.out.println(professorName + " assigned to teach " + course.getCourseName());
    }
}
