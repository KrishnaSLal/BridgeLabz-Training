package com.birdsanctuary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DeveloperInfo {
    String developer();
    String version();
}
