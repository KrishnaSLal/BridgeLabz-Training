package com.json.listtojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(101, "Toyota", "Camry"));
        cars.add(new Car(102, "Honda", "Civic"));
        cars.add(new Car(103, "Ford", "Mustang"));

        ObjectMapper mapper = new ObjectMapper();

        // Convert list to JSON array string
        String jsonArray = mapper.writeValueAsString(cars);

        System.out.println(jsonArray);
    }
}
