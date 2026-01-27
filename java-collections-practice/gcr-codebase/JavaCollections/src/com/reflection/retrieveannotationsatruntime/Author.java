package com.reflection.retrieveannotationsatruntime;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)   // Needed for runtime access
@Target(ElementType.TYPE)              // Can be applied to classes
@interface Author {
    String name();
}
