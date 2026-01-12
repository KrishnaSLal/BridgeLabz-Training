package com.medistore;
import java.time.LocalDate;


class Syrup extends Medicine {

    public Syrup(String name, double price, LocalDate expiryDate) {
        super(name, price, expiryDate);
    }

    @Override
    public boolean checkExpiry() {
        return expiryDate.isBefore(LocalDate.now().plusDays(5));
    }
}
