package com.runtimeanalysis.fibonnacicomputation;

import java.util.Scanner;

public class FibonacciComparison {
    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

     public static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int n = scanner.nextInt();

        long startTime = System.currentTimeMillis();
        long recursiveResult = fibonacciRecursive(n);
        long endTime = System.currentTimeMillis();
        
        
        System.out.println("Recursive Fibonacci Result: " + recursiveResult);
        System.out.println("Recursive Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        long iterativeResult = fibonacciIterative(n);
        endTime = System.currentTimeMillis();
        
        System.out.println("Iterative Fibonacci Result: " + iterativeResult);
        System.out.println("Iterative Time: " + (endTime - startTime) + " ms");

        scanner.close();
    }
}