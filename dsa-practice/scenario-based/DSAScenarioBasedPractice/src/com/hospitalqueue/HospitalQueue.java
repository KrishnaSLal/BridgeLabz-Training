package com.hospitalqueue;

class HospitalQueue {

    // Bubble Sort by Criticality (Descending Order)
    public static void sortByCriticality(Patient[] patients) {
        int n = patients.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                // Swap if next patient is more critical
                if (patients[j].criticality < patients[j + 1].criticality) {
                    Patient temp = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = temp;
                }
            }
        }
    }
}
