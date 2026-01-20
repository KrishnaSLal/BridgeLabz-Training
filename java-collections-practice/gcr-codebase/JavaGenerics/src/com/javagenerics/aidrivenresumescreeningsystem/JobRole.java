package com.javagenerics.aidrivenresumescreeningsystem;

abstract class JobRole {

    protected String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract void screenResume();
}
