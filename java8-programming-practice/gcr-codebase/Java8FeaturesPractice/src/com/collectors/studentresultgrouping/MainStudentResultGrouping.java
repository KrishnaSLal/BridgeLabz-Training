//Student Result Grouping
//○ Scenario: Group students by grade level and collect names.
//○ Task: Use Collectors.groupingBy().


package com.collectors.studentresultgrouping;

import java.util.*;
import java.util.stream.Collectors;

public class MainStudentResultGrouping {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Amit", "A"),
            new Student("Krishna", "B"),
            new Student("Rahul", "A"),
            new Student("Sneha", "C"),
            new Student("Varma", "B")
        );

        Map<String, List<String>> groupedByGrade =
                students.stream().collect(Collectors.groupingBy( Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList()) ));

        groupedByGrade.forEach((grade, names) ->
                System.out.println("Grade " + grade + " - " + names));
    }
}
