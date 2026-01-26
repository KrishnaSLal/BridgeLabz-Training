package com.javastreams.pipedstreams;

import java.util.Scanner;
import java.io.*;

public class MainPipedStream {
	
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Take user input
            System.out.print("Enter message to send between threads: ");
            String message = sc.nextLine();

            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create threads
            WriterThread writer = new WriterThread(pos, message);
            ReaderThread reader = new ReaderThread(pis);

            // Start threads
            reader.start();
            writer.start();

        } catch (IOException e) {
            System.out.println("Piped stream connection error");
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}

