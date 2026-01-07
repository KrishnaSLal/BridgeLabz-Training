package com.loanbuddy;

public class AutoLoan extends LoanApplication {

    public AutoLoan(Applicant applicant, int term) {
        super(applicant, term, 9.0); // higher interest
    }

    @Override
    public void approveLoan() {
        if (applicant.getCreditScore() >= 650 && applicant.getIncome() >= 20000) {
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
