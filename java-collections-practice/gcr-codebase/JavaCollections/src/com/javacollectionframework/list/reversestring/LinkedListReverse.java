package com.javacollectionframework.list.reversestring;

import java.util.LinkedList;

public class LinkedListReverse {

    public void reverse(LinkedList<Integer> list) {

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }
}
