package com.objectmodeling.companyanddepartments;

public class CompanyMain {
	public static void main(String[] args) {

        Company company = new Company("Tech Solutions");

        company.addDepartment("IT");
        company.addDepartment("HR");

        company.getDepartment(0).addEmployee(101, "Ravi");
        company.getDepartment(0).addEmployee(102, "Anita");

        company.getDepartment(1).addEmployee(201, "Suresh");

        company.displayCompanyDetails();

        System.out.println("\n--- Deleting Company ---");
        company.deleteCompany();
    }
}
