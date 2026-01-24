package com.javagenerics.multileveluniversitycoursemanagementsystem;

public class ExamCourse extends CourseType {

    public ExamCourse() {
        super("Written Examination");
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluated using final written exam.");
    }
}
class AssignmentCourse extends CourseType {

    public AssignmentCourse() {
        super("Assignments");
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluated using assignments and quizzes.");
    }
}
class ResearchCourse extends CourseType {

    public ResearchCourse() {
        super("Research Work");
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluated using research paper and presentation.");
    }
}
