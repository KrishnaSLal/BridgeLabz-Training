package com.javacollectionframework.map.keywithhighestvalue;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainHighestKeyValue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();

            System.out.print("Enter value: ");
            int value = sc.nextInt();

            map.put(key, value);
        }

        String result =HighestKeyValue.getKeyWithMaxValue(map);
        System.out.println("\nKey with highest value: " + result);

        sc.close();
    }
}
