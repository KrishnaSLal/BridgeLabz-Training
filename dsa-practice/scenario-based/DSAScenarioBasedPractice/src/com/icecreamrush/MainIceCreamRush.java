package com.icecreamrush;

import java.util.Scanner;
public class MainIceCreamRush {
   public static void main(String[]args) {
	   
	   Scanner sc = new Scanner(System.in);
	   String[] flavours = {"Vanilla", "Chocolate", "Spanish Delight", "Strawberry", "Pistachio", "Blue Berry", "Mango", "Cotton Candy"};
	   int[] unitsSold= new int[flavours.length];
	   
	   
	   System.out.println("Enter the Unit sold of Each flavours: ");
	   
	   for(int i=0; i<flavours.length; i++) {
		   System.out.print(flavours[i] + " = ");
		   unitsSold[i] = sc.nextInt();
	   }
	   
	   SalesManager.bubblesort(flavours, unitsSold);
	   
	   
	   for(int i=0; i<flavours.length; i++) {
		   System.out.println(flavours[i] + " | " + unitsSold[i]);
	   }
	   
	   
	   sc.close();
	   
   }
}
