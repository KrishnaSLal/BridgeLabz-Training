//3. Sensitive Data Tagging
//○ Scenario: Mark sensitive data classes for encryption.
//○ Task: Create a custom marker interface.


package com.interfaces.markerinterfaces.sensitivedatatagging;

import java.util.Scanner;

public class MainEncryption {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data: ");
        String value = sc.nextLine();

        System.out.print("Is this data sensitive? (yes/no): ");
        String choice = sc.nextLine();

        Object data;

        // User decides which class to create
        if (choice.equalsIgnoreCase("yes")) {
            data = new SensitiveInfo(value);
        } else {
            data = new NormalInfo(value);
        }

        processEncryption(data);

        sc.close();
    }

    // Encryption logic based on marker interface
    static void processEncryption(Object obj) {
        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data: " + obj);
        } else {
            System.out.println("No encryption required for: " + obj);
        }
    }
}

// Marked as sensitive
class SensitiveInfo implements SensitiveData {

    String data;

    SensitiveInfo(String data) {
        this.data = data;
    }

    public String toString() {
        return data;
    }
}

// Not marked
class NormalInfo {

    String data;

    NormalInfo(String data) {
        this.data = data;
    }

    public String toString() {
        return data;
    }
}
