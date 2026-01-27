package com.reflection.methodexecutiontiming;

public class MathOperations {

    public void addNumbers() {
        long sum = 0;
        for (int i = 1; i <= 1_000_000; i++) sum += i;
        System.out.println("Sum calculation done.");
    }

    public void multiplyNumbers() {
        long result = 1;
        for (int i = 1; i <= 10_000; i++) result *= i; // small range to avoid overflow
        System.out.println("Multiplication done.");
    }
}