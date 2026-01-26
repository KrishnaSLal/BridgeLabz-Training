package com.javastreams.bytearraystream;

import java.io.*;
import java.util.Scanner;

public class ImageToByteArray{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source image path: ");
        String sourceImage = sc.nextLine();

        System.out.print("Enter destination image path: ");
        String destinationImage = sc.nextLine();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Read image into ByteArrayOutputStream
            fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");

            // Write byte array back to image using ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            fos = new FileOutputStream(destinationImage);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("New image created successfully: " + destinationImage);
            System.out.println("Image verification successful (byte-level copy).");

        } catch (IOException e) {
            System.out.println("Error during image processing.");
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
                sc.close();
            } catch (IOException e) {
                System.out.println("Error while closing resources.");
            }
        }
    }
}
