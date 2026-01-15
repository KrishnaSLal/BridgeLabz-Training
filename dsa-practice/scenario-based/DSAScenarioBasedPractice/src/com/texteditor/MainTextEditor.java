package com.texteditor;

import java.util.Scanner;

public class MainTextEditor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TextActionManager manager = new TextActionManager();
        Editor editor = new Editor(manager);

        int choice;

        do {
            System.out.println("\nText Editor:");
            System.out.println("Current Text: \"" + editor.getText() + "\"");
            System.out.println("1. Insert Text");
            System.out.println("2. Delete Text");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter text to insert: ");
                    String insertText = sc.nextLine();
                    editor.insertText(insertText);
                    break;

                case 2:
                    System.out.print("Enter number of characters to delete: ");
                    int n = sc.nextInt();
                    editor.deleteText(n);
                    break;

                case 3:
                    editor.undo();
                    break;

                case 4:
                    editor.redo();
                    break;

                case 5:
                    System.out.println("Exiting editor...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
