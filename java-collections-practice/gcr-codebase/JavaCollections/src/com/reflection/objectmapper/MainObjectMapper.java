package com.reflection.objectmapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainObjectMapper {
   public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // user input
	        System.out.print("Enter Student ID: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();

	        System.out.print("Enter Student Name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter Course: ");
	        String course = scanner.nextLine();

	        // Store input in Map
	        Map<String, Object> data = new HashMap<>();
	        data.put("id", id);
	        data.put("name", name);
	        data.put("course", course);

	        // Map to object using Reflection
	        Student student =
	                ObjectMapperUtil.toObject(Student.class, data);


	        System.out.println("\n--- Student Object Created Dynamically ---");
	        student.display();

	        scanner.close();
	    }
	}
