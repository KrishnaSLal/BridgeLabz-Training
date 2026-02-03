package com.json.javaobjecttojson;

import org.json.JSONObject;
public class CarToJson {
    public static void main(String[] args) {

        Car car = new Car(101, "Toyota", "Camry", 32000);

        JSONObject carJson = new JSONObject();
        carJson.put("id", car.getId());
        carJson.put("brand", car.getBrand());
        carJson.put("model", car.getModel());
        carJson.put("price", car.getPrice());

        System.out.println(carJson.toString(2));
    }
}