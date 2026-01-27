package com.annotations.todo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Todo {
    String task();                 // Mandatory
    String assignedTo();            // Mandatory
    String priority() default "MEDIUM";  // Optional
}
