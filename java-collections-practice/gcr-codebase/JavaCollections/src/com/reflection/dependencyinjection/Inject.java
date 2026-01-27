package com.reflection.dependencyinjection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)   // Needed at runtime
@Target(ElementType.FIELD)             // Only applicable to fields
public @interface Inject {
}
