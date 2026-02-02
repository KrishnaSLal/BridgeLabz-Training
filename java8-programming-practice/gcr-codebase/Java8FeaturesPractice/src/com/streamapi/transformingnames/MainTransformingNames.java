package com.streamapi.transformingnames;

import java.util.*;
import java.util.stream.*;

public class MainTransformingNames {
    public static void main(String[] args) {

        List<String> customerNames = Arrays.asList(
                "Krishna", "Kurian", "Elza", "Minakshi", "Arushi"
        );

        customerNames.stream()
                     .map(String::toUpperCase)   
                     .sorted()                    
                     .forEach(System.out::println); 
    }
}
