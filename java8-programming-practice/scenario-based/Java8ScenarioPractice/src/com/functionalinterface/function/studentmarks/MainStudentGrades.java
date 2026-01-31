//Convert student marks into grade (A/B/C) using Function.


package com.functionalinterface.function.studentmarks;

import java.util.Scanner;
import java.util.function.Function;

public class MainStudentGrades {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the marks: ");
		double marks = sc.nextDouble();
		
		Function<Double, String> gradePredictor = m -> {
			if(m>=75) return "A";
			else if(m>=50) return "B";
			else if(m>=25) return "C";
			else return "Fail";
		};
		
		System.out.println("The grade remark is : " + gradePredictor.apply(marks));
		
		sc.close();
	}
}
