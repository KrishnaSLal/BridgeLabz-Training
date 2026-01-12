package com.searching.stringbuffer.comparestringbuffer;

import java.util.Scanner;

public class CompareConcatenation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of concatenations: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter string to concatenate: ");
        String text = scanner.nextLine();

        StringBuffer stringBuffer = new StringBuffer();
        long startBuffer = System.nanoTime();

        for (int i = 0; i < count; i++) {
            stringBuffer.append(text);
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        //StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        long startBuilder = System.nanoTime();

        for (int i = 0; i < count; i++) {
            stringBuilder.append(text);
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        System.out.println("\nPerformance Comparison:");
        System.out.println("StringBuffer Time   : " + bufferTime + " ns");
        System.out.println("StringBuilder Time : " + builderTime + " ns");

        scanner.close();
    }
}