package com.javagenerics.multileveluniversitycoursemanagementsystem;

import java.util.List;

class UniversityCourseManager {

    public static void evaluateAllCourses(List<? extends CourseType> courses) {

        for (CourseType course : courses) {
            course.evaluate();
        }
    }
}
