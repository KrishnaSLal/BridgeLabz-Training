package com.fitnesstracker;

public class Rankings {
   public static void bubbleSort(UserSteps[] users) {
	        
	int n = users.length;
	boolean swapped;

	for (int i = 0; i < n - 1; i++) {
	   
		swapped = false;

	for (int j = 0; j < n - i - 1; j++) {
	   if (users[j].getStep() < users[j + 1].getStep()) {
	      UserSteps temp = users[j];
	      users[j] = users[j + 1];
	      users[j + 1] = temp;
	      swapped = true;
	                }
	            }

	         
	      if (!swapped) {
	      break;
	            }
	        }
	    }


}
