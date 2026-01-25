package com.javacollectionframework.findingelement;

import java.util.*;

public class NthElementFromEnd {

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<String> list = new LinkedList<>();

        // Number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Elements input
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Nth position from end
        System.out.print("Enter N (from end): ");
        int N = sc.nextInt();

        //Validation Check
        if (N <= 0 || N > list.size()) {
            System.out.println("Invalid N value");
            return;
        }

        // Two-pointer approach (iterators)
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();

        // Move first N steps ahead
        for (int i = 0; i < N; i++) {
            first.next();
        }
        // Move both until first reaches end
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        System.out.println("Nth element from end: " + second.next());

        sc.close();
    }
}
