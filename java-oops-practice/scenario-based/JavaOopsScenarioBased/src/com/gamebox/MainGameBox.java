package com.gamebox;

import java.util.Scanner;

public class MainGameBox {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        User user = new User(sc.nextLine());

        Game arcade = new ArcadeGame("Speed Racer", 299, 4.5);
        Game strategy = new StrategyGame("War Tactics", 499, 4.7);

        while (true) {
            System.out.println("\nGameBox Menu");
            System.out.println("1. View Games");
            System.out.println("2. Play Demo");
            System.out.println("3. Buy Game");
            System.out.println("4. Apply Seasonal Offer");
            System.out.println("5. View Owned Games");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("1. Speed Racer (Arcade) ₹" + arcade.getPrice());
                    System.out.println("2. War Tactics (Strategy) ₹" + strategy.getPrice());
                    break;

                case 2:
                    System.out.print("Select Game (1 or 2): ");
                    int d = sc.nextInt();
                    if (d == 1) arcade.playDemo();
                    else strategy.playDemo();
                    break;

                case 3:
                    System.out.print("Select Game to Buy (1 or 2): ");
                    int b = sc.nextInt();
                    if (b == 1) user.buyGame(arcade);
                    else user.buyGame(strategy);
                    break;

                case 4:
                    System.out.print("Enter discount amount: ");
                    double discount = sc.nextDouble();
                    arcade.applyOffer(discount);
                    strategy.applyOffer(discount);
                    System.out.println("Seasonal offer applied!");
                    break;

                case 5:
                    user.showOwnedGames();
                    break;

                case 6:
                    System.out.println("Exiting GameBox");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
