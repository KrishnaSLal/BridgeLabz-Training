package com.loanbuddy;

public abstract class LoanApplication implements IApprovable {

    protected Applicant applicant;
    protected int term; // in months
    protected double interestRate; // annual
    private boolean approved; // restricted access

    public LoanApplication(Applicant applicant, int term, double interestRate) {
        this.applicant = applicant;
        this.term = term;
        this.interestRate = interestRate;
    }

    protected void setApproved(boolean status) {
        this.approved = status;
    }

    public boolean isApproved() {
        return approved;
    }
}
