package com.objectmodeling.companyanddepartments;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Company creates and owns departments
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public Department getDepartment(int index) {
        return departments.get(index);
    }

    public void displayCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    // Simulate deletion of company
    public void deleteCompany() {
        departments.clear(); // removes all departments and employees
        System.out.println("Company deleted along with all departments and employees.");
    }
}
