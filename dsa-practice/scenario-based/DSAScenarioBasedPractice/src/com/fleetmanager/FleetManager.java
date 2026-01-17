package com.fleetmanager;

public class FleetManager {

    public static void mergeSort(DepotList[] vehicles, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(vehicles, left, mid);
            mergeSort(vehicles, mid + 1, right);

            merge(vehicles, left, mid, right);
        }
    }

    private static void merge(DepotList[] vehicles, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        DepotList[] leftArr = new DepotList[n1];
        DepotList[] rightArr = new DepotList[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = vehicles[left + i];

        for (int j = 0; j < n2; j++)
            rightArr[j] = vehicles[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i].getMileage() <= rightArr[j].getMileage()) {
                vehicles[k++] = leftArr[i++];
            } else {
                vehicles[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            vehicles[k++] = leftArr[i++];
        }

        while (j < n2) {
            vehicles[k++] = rightArr[j++];
        }
    }
}
