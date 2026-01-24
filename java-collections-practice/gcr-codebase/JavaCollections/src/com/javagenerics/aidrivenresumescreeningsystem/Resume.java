package com.javagenerics.aidrivenresumescreeningsystem;

public class Resume<T extends JobRole> {

    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void processResume() {
        System.out.println("Candidate: " + candidateName +
                " | Role Applied: " + jobRole.getRoleName());
        jobRole.screenResume();
    }
}
