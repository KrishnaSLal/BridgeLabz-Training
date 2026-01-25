package com.javacollectionframework.list.reversestring;

import java.util.ArrayList;

public class ArrayListReverse{

    public void reverse(ArrayList<Integer> list) {

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
