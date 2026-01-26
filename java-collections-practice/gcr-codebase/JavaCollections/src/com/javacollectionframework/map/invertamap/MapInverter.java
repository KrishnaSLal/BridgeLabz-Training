package com.javacollectionframework.map.invertamap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapInverter {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {

        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {

            V value = entry.getValue();
            K key = entry.getKey();

            // Add key to list for the value
            invertedMap
                .computeIfAbsent(value, k -> new ArrayList<>())
                .add(key);
        }

        return invertedMap;
    }
}
