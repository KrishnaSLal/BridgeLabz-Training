package com.javastreams.bufferedstreams;

import java.io.*;
import java.util.Scanner;

public class BufferedStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file path: ");
        String sourceFile = sc.nextLine();

        System.out.print("Enter destination file path for buffered copy: ");
        String destBuffered = sc.nextLine();

        System.out.print("Enter destination file path for unbuffered copy: ");
        String destUnbuffered = sc.nextLine();

        File src = new File(sourceFile);
        if (!src.exists()) {
            System.out.println("Source file does not exist: " + sourceFile);
            sc.close();
            return;
        }

        // Copy using Buffered Streams
        long bufferedStart = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered))) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during buffered copy: " + e.getMessage());
            e.printStackTrace();
        }
        long bufferedEnd = System.nanoTime();
        long bufferedTime = bufferedEnd - bufferedStart;

        // Copy using normal File Streams (unbuffered)
        long unbufferedStart = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(destUnbuffered)) {

            byte[] buffer = new byte[4096]; // same 4 KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during unbuffered copy: " + e.getMessage());
            e.printStackTrace();
        }
        long unbufferedEnd = System.nanoTime();
        long unbufferedTime = unbufferedEnd - unbufferedStart;

        System.out.println("\nCopy completed!");
        System.out.println("Buffered copy time:   " + bufferedTime / 1_000_000 + " ms");
        System.out.println("Unbuffered copy time: " + unbufferedTime / 1_000_000 + " ms");

        if (bufferedTime < unbufferedTime) {
            System.out.println("Buffered copy was faster.");
        } else if (bufferedTime > unbufferedTime) {
            System.out.println("Unbuffered copy was faster (rare, usually small files).");
        } else {
            System.out.println("Both methods took the same time.");
        }

        sc.close();
    }
}
