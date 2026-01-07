package com.loanbuddy;

import java.util.Scanner;

public class MainLoanBuddy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Credit Score: ");
        int creditScore = sc.nextInt();

        System.out.print("Enter Monthly Income: ");
        double income = sc.nextDouble();

        System.out.print("Enter Loan Amount: ");
        double loanAmount = sc.nextDouble();

        System.out.print("Enter Loan Type (1-Home, 2-Auto): ");
        int choice = sc.nextInt();

        System.out.print("Enter Loan Term (months): ");
        int term = sc.nextInt();

        Applicant applicant = new Applicant(name, creditScore, income, loanAmount);
        LoanApplication loan;

        if (choice == 1) {
            loan = new HomeLoan(applicant, term);
        } else {
            loan = new AutoLoan(applicant, term);
        }

        loan.approveLoan();

        if (loan.isApproved()) {
            System.out.println("\n✅ Loan Approved!");
            System.out.printf("Monthly EMI: %.2f\n", loan.calculateEMI());
        } else {
            System.out.println("\n❌ Loan Rejected due to eligibility criteria.");
        }

        sc.close();
    }
}
