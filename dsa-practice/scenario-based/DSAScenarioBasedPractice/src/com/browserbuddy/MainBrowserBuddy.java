package com.browserbuddy;

import java.util.Scanner;
import java.util.Stack;

public class MainBrowserBuddy {
   public static void main(String[]args) {
		        
	   Scanner sc = new Scanner(System.in);
	   ClosedTabs tab = new ClosedTabs();
		        Stack<ClosedTabs> closedTabs = new Stack<>();

		        while (true) {
		            System.out.println("\nBrowserBuddy Menu: ");
		            System.out.println("1. Visit Page");
		            System.out.println("2. Back");
		            System.out.println("3. Forward");
		            System.out.println("4. Close Tab");
		            System.out.println("5. Restore Closed Tab");
		            System.out.println("6. Current Page");
		            System.out.println("7. Exit");
		            System.out.print("Choose option:(1-7)");

		            int choice = sc.nextInt();
		            sc.nextLine(); // consume newline

		            switch (choice) {
		                case 1:
		                    System.out.print("Enter URL: ");
		                    String url = sc.nextLine();
		                    tab.visit(url);
		                    break;

		                case 2:
		                    tab.back();
		                    break;

		                case 3:
		                    tab.forward();
		                    break;

		                case 4:
		                    closedTabs.push(tab);
		                    tab = new ClosedTabs();
		                    System.out.println("Tab closed.");
		                    break;

		                case 5:
		                    if (!closedTabs.isEmpty()) {
		                        tab = closedTabs.pop();
		                        System.out.println("Tab restored. Current page: " + tab.getCurrentPage());
		                    } else {
		                        System.out.println("No closed tabs to restore.");
		                    }
		                    break;

		                case 6:
		                    System.out.println("Current Page: " + tab.getCurrentPage());
		                    break;

		                case 7:
		                    System.out.println("Exiting BrowserBuddy...");
		                    sc.close();
		                    return;

		                default:
		                    System.out.println("Invalid option!");
		            }
		        }
	   
   }
}
