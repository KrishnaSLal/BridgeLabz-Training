package com.medistore;

import java.time.LocalDate;

public class MainMedicalStore{

    public static void main(String[] args) {

        Medicine tablet = new Tablet("Paracetamol", 5.0, LocalDate.of(2026, 5, 10));

        Medicine syrup = new Syrup("Cough Syrup",120.0, LocalDate.now().plusDays(3));

        Medicine injection = new Injection("Insulin",450.0,LocalDate.now().plusDays(1));

        tablet.sell(50);
        syrup.sell(5);
        injection.sell(2);

        System.out.println("Remaining Tablet Stock: " + tablet.getQuantity());
    }
}
