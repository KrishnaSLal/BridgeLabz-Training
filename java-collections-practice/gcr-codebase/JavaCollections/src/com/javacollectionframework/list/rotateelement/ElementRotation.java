package com.javacollectionframework.list.rotateelement;

import java.util.*;

public class ElementRotation {

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);

        // Number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        // input
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Rotation count
        System.out.print("Enter rotation count: ");
        int k = sc.nextInt();

        //Inorder to handle the rotation which is greater than the size
        k = k % n;

        // Rotate left
        List<Integer> rotatedList = new ArrayList<>();

        rotatedList.addAll(list.subList(k, n));
        rotatedList.addAll(list.subList(0, k));

        System.out.println("Rotated List:");
        System.out.println(rotatedList);

        sc.close();
    }
}
