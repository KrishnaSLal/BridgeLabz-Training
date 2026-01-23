package com.gamerzone;

public class RankingSystem {

    public void quickSort(Scores[] arr, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(Scores[] arr, int low, int high) {

        int pivot = arr[high].getScore();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getScore() > pivot) {
                i++;

                Scores temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Scores temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public void display(Scores[] arr) {
        for (Scores s : arr) {
            System.out.println(s);
        }
    }
}
