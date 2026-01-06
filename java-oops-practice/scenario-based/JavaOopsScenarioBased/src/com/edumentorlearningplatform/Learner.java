package com.edumentorlearningplatform;

public class Learner extends User implements ICertifiable {

    private boolean isFullTime;

    public Learner(String name, String email, int userId, boolean isFullTime) {
        super(name, email, userId);
        this.isFullTime = isFullTime;
    }

    // Polymorphism
    @Override
    public void generateCertificate() {
        if (isFullTime) {
            System.out.println("Full-Time Course Certificate generated for " + name);
        } else {
            System.out.println("Short Course Certificate generated for " + name);
        }
    }
}
