package com.medwarehouse;

public class MedicineRecords {

    public static void mergeSort(Medicine[] medicines, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(medicines, left, mid);
            mergeSort(medicines, mid + 1, right);

            merge(medicines, left, mid, right);
        }
    }

    private static void merge(Medicine[] medicines, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Medicine[] L = new Medicine[n1];
        Medicine[] R = new Medicine[n2];

        for (int i = 0; i < n1; i++)
            L[i] = medicines[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = medicines[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].getExpiryDays() <= R[j].getExpiryDays()) {
                medicines[k++] = L[i++];
            } else {
                medicines[k++] = R[j++];
            }
        }

        while (i < n1)
            medicines[k++] = L[i++];

        while (j < n2)
            medicines[k++] = R[j++];
    }
}
