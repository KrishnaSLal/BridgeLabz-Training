package com.annotations.customcachingsystem;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheManager {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeWithCache(
            Object target,
            String methodName,
            Class<?>[] paramTypes,
            Object[] args) throws Exception {

        Method method = target.getClass().getMethod(methodName, paramTypes);

        // Build cache key (method and arguments)
        String cacheKey = methodName + "_" + args[0];

        if (method.isAnnotationPresent(CacheResult.class)) {

            if (cache.containsKey(cacheKey)) {
                System.out.println("Returning cached result");
                return cache.get(cacheKey);
            }

            System.out.println("Cache miss → computing result");
            Object result = method.invoke(target, args);
            cache.put(cacheKey, result);
            return result;
        }

        // If method is not annotated
        return method.invoke(target, args);
    }
}
