package com.javacollectionframework.map.keywithhighestvalue;

import java.util.Map;

public class HighestKeyValue {

    public static String getKeyWithMaxValue(Map<String, Integer> map) {

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
