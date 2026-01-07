package com.loanbuddy;

public class HomeLoan extends LoanApplication {

    public HomeLoan(Applicant applicant, int term) {
        super(applicant, term, 7.5); // lower interest
    }

    @Override
    public void approveLoan() {
        if (applicant.getCreditScore() >= 700 && applicant.getIncome() >= 30000) {
            setApproved(true);
        } else {
            setApproved(false);
        }
    }

    @Override
    public double calculateEMI() {
        double P = applicant.getLoanAmount();
        double R = interestRate / (12 * 100);
        int N = term;

        return (P * R * Math.pow(1 + R, N)) /
               (Math.pow(1 + R, N) - 1);
    }
}
