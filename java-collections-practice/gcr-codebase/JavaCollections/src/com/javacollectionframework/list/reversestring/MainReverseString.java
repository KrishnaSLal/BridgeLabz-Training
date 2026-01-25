package com.javacollectionframework.reversestring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MainReverseString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.print("Enter number of elements for ArrayList: ");
        int n1 = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n1; i++) {
            arrayList.add(sc.nextInt());
        }

        ArrayListReverse arrayReverser = new ArrayListReverse();

        System.out.println("Original ArrayList: " + arrayList);
        arrayReverser.reverse(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        //LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.print("\nEnter number of elements for LinkedList: ");
        int n2 = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n2; i++) {
            linkedList.add(sc.nextInt());
        }

        LinkedListReverse linkedReverser = new LinkedListReverse();

        System.out.println("Original LinkedList: " + linkedList);
        linkedReverser.reverse(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);

        sc.close();
    }
}
