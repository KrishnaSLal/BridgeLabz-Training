//Print student details using Consumer.


package com.functionalinterface.consumer.printstudentdetails;

import java.util.function.Consumer;
import java.util.Scanner;

class Student{
	
	String name;
	int age;
	double marks;
	
	Student(String name, int age, double marks){
		
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
}
public class MainStudentDetails {
   public static void main(String[] args) {
	   
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter the student name: ");
	   String name = sc.nextLine();
	   
	   System.out.println("Enter the age: ");
	   int age = sc.nextInt();
	   
	   System.out.println("Enter the marks: ");
	   double marks = sc.nextDouble();
	   
	   Student student = new Student(name, age, marks);	
	   
	  Consumer<Student> printer = s -> {
           System.out.println("Student Details: ");
           System.out.println("Name  : " + s.name);
           System.out.println("Age   : " + s.age);
           System.out.println("Marks : " + s.marks);
       };

       printer.accept(student);
	   
	   sc.close();
   }
}
