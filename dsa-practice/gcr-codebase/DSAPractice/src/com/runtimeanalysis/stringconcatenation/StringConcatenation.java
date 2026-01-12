package com.runtimeanalysis.stringconcatenation;

import java.util.Scanner;

public class StringConcatenation {
	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of concatenations: ");
        int n = scanner.nextInt();

        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) {
            str = str + "a";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ms");

        scanner.close();
    }
}