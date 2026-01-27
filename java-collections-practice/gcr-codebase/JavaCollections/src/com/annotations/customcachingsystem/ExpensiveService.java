package com.annotations.customcachingsystem;

public class ExpensiveService {

    @CacheResult
    public int computeSquare(int number) {
        System.out.println("Performing expensive computation...");
        try {
            Thread.sleep(2000); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * number;
    }
}
