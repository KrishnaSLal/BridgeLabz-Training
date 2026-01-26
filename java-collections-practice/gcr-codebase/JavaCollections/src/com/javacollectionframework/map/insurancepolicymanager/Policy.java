package com.javacollectionframework.map.insurancepolicymanager;

import java.time.LocalDate;

public class Policy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private double premium;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate, double premium) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.premium = premium;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public double getPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return "Policy{" + "Number='" + policyNumber + '\'' +", Holder='" + policyHolderName + '\'' +", Expiry=" + expiryDate + ", Premium=" + premium +'}';
    }
}
