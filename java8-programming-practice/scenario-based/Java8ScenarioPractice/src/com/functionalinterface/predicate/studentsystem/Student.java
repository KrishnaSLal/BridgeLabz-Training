package com.functionalinterface.predicate.studentsystem;

@FunctionalInterface
interface ExamEligibility {
    boolean check(Student student);
}
