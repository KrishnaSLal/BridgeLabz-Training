package com.icecreamrush;

public class SalesManager {
	
	public static void bubblesort(String[] flavours, int[] unitsSold) {
		
		int n = flavours.length;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(unitsSold[j] > unitsSold[j+1]) {
					int temp1 = unitsSold[j];
					unitsSold[j] = unitsSold[j+1];
					unitsSold[j+1] = temp1;
					
					String temp2 = flavours[j];
					flavours[j] = flavours[j+1];
					flavours[j+1] = temp2;
				}					
					
			}
		}
		
		
	}
	
	
	
}

