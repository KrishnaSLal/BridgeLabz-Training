package com.csvdatahandling.advancedproblems.encryptanddecrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCsv {

    private static final String ALGO = "AES";
    private static final byte[] KEY = "MySecretKey12345".getBytes(); 

    public static void main(String[] args) throws Exception {

        writeEncryptedCSV("employees_encrypted.csv");
        readDecryptedCSV("employees_encrypted.csv");
    }

    //Encrypt text
    static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY, ALGO));
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    //Decrypt text
    static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY, ALGO));
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }

    //Write encrypted CSV
    static void writeEncryptedCSV(String fileName) throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write("id,name,email,salary");
            bw.newLine();

            bw.write("1,Krishna," +encrypt("krishna@gmail.com") + "," + encrypt("50000"));
            bw.newLine();

            bw.write("2,Rahul," +encrypt("rahul@yahoo.com") + "," +encrypt("45000"));
        }

        System.out.println("Encrypted CSV written successfully");
    }

    // Read & decrypt CSV
    static void readDecryptedCSV(String fileName) throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line = br.readLine(); // skip header
            System.out.println("\n Decrypted Data:");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println("ID: " + data[0] +", Name: " + data[1] +", Email: " + decrypt(data[2]) +", Salary: " + decrypt(data[3]));
            }
        }
    }
}
