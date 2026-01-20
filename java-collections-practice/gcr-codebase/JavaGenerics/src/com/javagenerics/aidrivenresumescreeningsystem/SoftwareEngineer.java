package com.javagenerics.aidrivenresumescreeningsystem;

public class SoftwareEngineer extends JobRole {

    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void screenResume() {
        System.out.println("Screening for coding skills, DSA, and system design.");
    }
}
class DataScientist extends JobRole {

    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void screenResume() {
        System.out.println("Screening for statistics, ML models, and data analysis.");
    }
}
class ProductManager extends JobRole {

    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void screenResume() {
        System.out.println("Screening for product sense, leadership, and strategy.");
    }
}
