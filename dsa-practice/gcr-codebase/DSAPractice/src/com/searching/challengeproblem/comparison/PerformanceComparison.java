package com.searching.challengeproblem.comparison;

//Compare StringBuilder, StringBuffer, FileReader, and InputStreamReader


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PerformanceComparison {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

           //TAKE USER INPUT
        
        System.out.print("Enter file path (example: C:\\\\data\\\\largefile.txt): ");
        String filePath = sc.nextLine();

          // PART 1: StringBuilder vs StringBuffer

        int iterations = 1_000_000;
        String text = "hello";

        long startSB = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endSB = System.currentTimeMillis();

        long startSBuf = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append(text);
        }
        long endSBuf = System.currentTimeMillis();

        System.out.println("\nStringBuilder Time : " + (endSB - startSB) + " ms");
        System.out.println("StringBuffer Time  : " + (endSBuf - startSBuf) + " ms");

           //PART 2: FileReader vs InputStreamReader
          
        long startFR = System.currentTimeMillis();
        long wordsFR = countWordsUsingFileReader(filePath);
        long endFR = System.currentTimeMillis();

        long startISR = System.currentTimeMillis();
        long wordsISR = countWordsUsingInputStreamReader(filePath);
        long endISR = System.currentTimeMillis();

        System.out.println("\nFileReader Word Count        : " + wordsFR);
        System.out.println("FileReader Time             : " + (endFR - startFR) + " ms");

        System.out.println("\nInputStreamReader Word Count : " + wordsISR);
        System.out.println("InputStreamReader Time      : " + (endISR - startISR) + " ms");

        sc.close();
    }

    // FileReader
    public static long countWordsUsingFileReader(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        long count = 0;
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                count += line.trim().split("\\s+").length;
            }
        }
        br.close();
        return count;
    }

    // InputStreamReader
    public static long countWordsUsingInputStreamReader(String path) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)
        );
        long count = 0;
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                count += line.trim().split("\\s+").length;
            }
        }
        br.close();
        return count;
    }
}

