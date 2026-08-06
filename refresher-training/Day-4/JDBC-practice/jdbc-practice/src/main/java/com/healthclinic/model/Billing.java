package com.healthclinic.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    private int billId;
    private int visitId;
    private double amount;
    private String paymentStatus;

    public Billing(int visitId, double amount, String paymentStatus) {
        this.visitId = visitId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

}