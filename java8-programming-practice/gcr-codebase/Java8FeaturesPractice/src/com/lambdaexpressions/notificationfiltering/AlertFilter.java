package com.lambdaexpressions.notificationfiltering;

@FunctionalInterface
interface AlertFilter {
    boolean filter(Alert alert);
}
