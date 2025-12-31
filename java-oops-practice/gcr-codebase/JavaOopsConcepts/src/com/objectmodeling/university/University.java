package com.objectmodeling.university;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String universityName;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showDepartments() {
        System.out.println("Departments in " + universityName + ":");
        for (Department dept : departments) {
            System.out.println(dept.getDepartmentName());
        }
    }

    public void showFaculties() {
        System.out.println("Faculty members in " + universityName + ":");
        for (Faculty faculty : faculties) {
            System.out.println(faculty.getFacultyName());
        }
    }

    public void deleteUniversity() {
        departments.clear();
        System.out.println("University deleted. All departments removed.");
    }
}