package com.javagenerics.aidrivenresumescreeningsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainResumeScreeningSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<JobRole> rolePipeline = new ArrayList<>();

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nCandidate " + i);
            System.out.print("Enter candidate name: ");
            String name = sc.nextLine();

            System.out.println("Select Job Role:");
            System.out.println("1. Software Engineer");
            System.out.println("2. Data Scientist");
            System.out.println("3. Product Manager");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        Resume<SoftwareEngineer> seResume = ResumeService.generateResume(name, new SoftwareEngineer());
                        seResume.processResume();
                        rolePipeline.add(seResume.getJobRole());
                        break;

                    case 2:
                        Resume<DataScientist> dsResume =ResumeService.generateResume(name, new DataScientist());
                        dsResume.processResume();
                        rolePipeline.add(dsResume.getJobRole());
                        break;

                    case 3:
                        Resume<ProductManager> pmResume = ResumeService.generateResume(name, new ProductManager());
                        pmResume.processResume();
                        rolePipeline.add(pmResume.getJobRole());
                        break;

                    default:
                        System.out.println("Invalid role selection");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Wildcard
        Screening.runScreening(rolePipeline);

        sc.close();
    }
}