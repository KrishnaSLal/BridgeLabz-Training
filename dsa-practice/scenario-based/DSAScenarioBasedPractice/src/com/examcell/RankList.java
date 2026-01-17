package com.examcell;

public class RankList {

    public static void mergeSort(Student[] students, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(students, left, mid);
            mergeSort(students, mid + 1, right);

            merge(students, left, mid, right);
        }
    }

    private static void merge(Student[] students, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArr = new Student[n1];
        Student[] rightArr = new Student[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = students[left + i];

        for (int j = 0; j < n2; j++)
            rightArr[j] = students[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Sort by score (descending for rank list)
        while (i < n1 && j < n2) {
            if (leftArr[i].getScore() >= rightArr[j].getScore()) {
                students[k++] = leftArr[i++];
            } else {
                students[k++] = rightArr[j++];
            }
        }

        while (i < n1)
            students[k++] = leftArr[i++];

        while (j < n2)
            students[k++] = rightArr[j++];
    }
}
