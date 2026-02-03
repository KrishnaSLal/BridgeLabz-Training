package com.json.jsontoxml;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {

    public static void main(String[] args) {

        String jsonString = "{ \"name\":\"Krishna\", \"email\":\"krishna@gmail.com\", \"age\":25 }";

        JSONObject jsonObject = new JSONObject(jsonString);

        String xml = XML.toString(jsonObject);

        System.out.println(xml);
    }
}

