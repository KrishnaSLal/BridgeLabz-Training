package com.javacollectionframework.queue.binarynumber;

import java.util.*;

public class BinaryNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        Queue<String> queue = new LinkedList<>();

        List<String> result = new ArrayList<>();

       
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }

        // Output
        System.out.println("First " + n + " binary numbers:");
        System.out.println(result);

        sc.close();
    }
}
