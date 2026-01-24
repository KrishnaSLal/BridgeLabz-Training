package com.javagenerics.aidrivenresumescreeningsystem;

import java.util.List;

public class Screening {

    public static void runScreening(List<? extends JobRole> roles) {
        System.out.println("\n--- Screening Pipeline ---");
        for (JobRole role : roles) {
            role.screenResume();
        }
    }
}
