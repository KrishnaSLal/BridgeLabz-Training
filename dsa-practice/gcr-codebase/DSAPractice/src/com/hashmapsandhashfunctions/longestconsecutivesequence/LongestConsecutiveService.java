package com.hashmapsandhashfunctions.longestconsecutivesequence;

	import java.util.HashSet;

	public class LongestConsecutiveService {

	    public static int findLongestConsecutiveSequence(int[] arr) {
	        HashSet<Integer> set = new HashSet<>();

	        // Store all elements in set
	        for (int num : arr) {
	            set.add(num);
	        }

	        int longestStreak = 0;

	        for (int num : arr) {
	            // Check if num is the start of a sequence
	            if (!set.contains(num - 1)) {
	                int currentNum = num;
	                int currentStreak = 1;

	                // Count consecutive numbers
	                while (set.contains(currentNum + 1)) {
	                    currentNum++;
	                    currentStreak++;
	                }

	                longestStreak = Math.max(longestStreak, currentStreak);
	            }
	        }

	        return longestStreak;
	    }
	}
