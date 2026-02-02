//Insurance Claim Analysis
//○ Scenario: Find the average claim amount for each claim type.
//○ Task: Use groupingBy() and averagingDouble().


package com.streamapi.insuranceclaimanalysis;

import java.util.*;
import java.util.stream.*;

class InsuranceClaim {
    String claimType;
    double amount;

    InsuranceClaim(String claimType, double amount) {
        this.claimType = claimType;
        this.amount = amount;
    }

    String getClaimType() {
        return claimType;
    }

    double getAmount() {
        return amount;
    }
}

public class MainClaimAnalysis {
    public static void main(String[] args) {

        List<InsuranceClaim> claims = Arrays.asList(
                new InsuranceClaim("Health", 50000),
                new InsuranceClaim("Health", 30000),
                new InsuranceClaim("Vehicle", 20000),
                new InsuranceClaim("Vehicle", 40000),
                new InsuranceClaim("Life", 100000)
        );

        // Group by claim type and calculate average amount
        Map<String, Double> averageClaimAmount =
                claims.stream()
                      .collect(Collectors.groupingBy(
                              InsuranceClaim::getClaimType,
                              Collectors.averagingDouble(InsuranceClaim::getAmount)
                      ));

        averageClaimAmount.forEach((type, avg) ->
                System.out.println(type + " Average Claim Amount: ₹" + avg));
    }
}
