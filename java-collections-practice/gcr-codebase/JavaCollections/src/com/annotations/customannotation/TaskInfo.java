package com.annotations.customannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Retain at runtime so we can access via Reflection
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)  // Annotation applies to methods
public @interface TaskInfo {
    String priority();
    String assignedTo();
}
