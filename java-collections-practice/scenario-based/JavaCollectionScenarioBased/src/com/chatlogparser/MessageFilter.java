package com.chatlogparser;

@FunctionalInterface
public interface MessageFilter<T> {
    boolean filter(T message);
}
