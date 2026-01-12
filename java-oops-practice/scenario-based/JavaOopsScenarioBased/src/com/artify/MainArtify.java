package com.artify;

import java.util.Scanner;

public class MainArtify {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User details
        System.out.print("Enter user name: ");
        String userName = sc.nextLine();

        System.out.print("Enter wallet balance: ");
        double walletBalance = sc.nextDouble();
        sc.nextLine(); // consume newline

        User user = new User(userName, walletBalance);

        // Artwork details
        System.out.print("\nEnter artwork type (1-Digital, 2-Print): ");
        int artType = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter artwork title: ");
        String title = sc.nextLine();

        System.out.print("Enter artist name: ");
        String artist = sc.nextLine();

        System.out.print("Enter artwork price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter license type: ");
        String licenseType = sc.nextLine();

        Artwork artwork;

        if (artType == 1) {
            System.out.print("Is preview available? (true/false): ");
            boolean hasPreview = sc.nextBoolean();

            artwork = new DigitalArt(
                    title,
                    artist,
                    price,
                    licenseType,
                    hasPreview
            );
        } else {
            artwork = new PrintArt(
                    title,
                    artist,
                    price,
                    licenseType
            );
        }

        // Purchase
        System.out.println("\nProcessing Purchase...");
        artwork.purchase(user);

        // License
        System.out.println("\nApplying License...");
        artwork.license(user);

        // Final wallet balance
        System.out.println("\nRemaining Wallet Balance: ₹" + user.getWalletBalance());

        sc.close();
    }
}
