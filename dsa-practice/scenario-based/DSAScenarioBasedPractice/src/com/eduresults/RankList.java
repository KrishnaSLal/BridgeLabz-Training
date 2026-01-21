package com.eduresults;

public class RankList {

	public static void mergeSort(Marks[] students, int left, int right) {
	     if (left < right) {
	         int mid = (left + right) / 2;

	         mergeSort(students, left, mid);
	         mergeSort(students, mid + 1, right);

	         merge(students, left, mid, right);
	     }
	 }
	 private static void merge(Marks[] students, int left, int mid, int right) {
	     int n1 = mid - left + 1;
	     int n2 = right - mid;

	     Marks[] L = new Marks[n1];
	     Marks[] R = new Marks[n2];

	     for (int i = 0; i < n1; i++)
	         L[i] = students[left + i];

	     for (int j = 0; j < n2; j++)
	         R[j] = students[mid + 1 + j];

	     int i = 0, j = 0, k = left;

	        //descending sort
	     while (i < n1 && j < n2) {
	         if (L[i].getMarks() >= R[j].getMarks()) {
	             students[k++] = L[i++];
	         } else {
	             students[k++] = R[j++];
	         }
	     }

	     while (i < n1) {
	         students[k++] = L[i++];
	     }
	      while (j < n2) {
	         students[k++] = R[j++];
	      }
	 }
}
