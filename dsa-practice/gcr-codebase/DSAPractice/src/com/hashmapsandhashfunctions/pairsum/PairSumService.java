package com.hashmapsandhashfunctions.pairsum;

import java.util.HashSet;

public class PairSumService {

    // Returns true if a pair with given sum exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (set.contains(complement)) {
                System.out.println("Pair found: " + num + " + " + complement + " = " + target);
                return true;
            }
            set.add(num);
        }
        return false;
    }
}