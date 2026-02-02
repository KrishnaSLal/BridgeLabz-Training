package com.tree.avltree.hospitalqueuemanagement;

class HospitalQueueBST {

    PatientNode root;

    // Patient Registration
    void register(Patient p, int checkInTime) {
        root = insertRec(root, p, checkInTime);
    }

    private PatientNode insertRec(PatientNode root, Patient p, int checkInTime) {
        if (root == null) return new PatientNode(checkInTime, p);

        if (checkInTime < root.checkInTime) root.left = insertRec(root.left, p, checkInTime);
        else if (checkInTime > root.checkInTime) root.right = insertRec(root.right, p, checkInTime);
        else root.patients.add(p); // same time → add to list

        return root;
    }

    // Discharge/Delete Record
    void discharge(int patientID) {
        root = dischargeRec(root, patientID);
    }

    private PatientNode dischargeRec(PatientNode root, int patientID) {
        if (root == null) return null;

        root.patients.removeIf(p -> p.patientID == patientID);

        if (root.patients.isEmpty()) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            PatientNode successor = minValue(root.right);
            root.checkInTime = successor.checkInTime;
            root.patients = successor.patients;
            root.right = dischargeRec(root.right, successor.patients.get(0).patientID);
        } else {
            root.left = dischargeRec(root.left, patientID);
            root.right = dischargeRec(root.right, patientID);
        }

        return root;
    }

    private PatientNode minValue(PatientNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Display by Arrival Time
    void displayPatients() {
        if (root == null) {
            System.out.println("No patients registered.");
            return;
        }
        System.out.println("\n--- Patients by Arrival Time ---");
        inorder(root);
    }

    private void inorder(PatientNode root) {
        if (root != null) {
            inorder(root.left);
            for (Patient p : root.patients) {
                System.out.println("Check-in: " + root.checkInTime + 
                                   " | Patient ID: " + p.patientID + 
                                   " | Name: " + p.name);
            }
            inorder(root.right);
        }
    }
}
