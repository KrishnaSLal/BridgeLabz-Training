package com.javacollectionframework.map.mergetwomaps;

import java.util.HashMap;
import java.util.Map;

public class MapMerger {

    public static Map<String, Integer> mergeMaps(
            Map<String, Integer> map1,
            Map<String, Integer> map2) {

        Map<String, Integer> result = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            result.put(key, result.getOrDefault(key, 0) + value);
        }

        return result;
    }
}
