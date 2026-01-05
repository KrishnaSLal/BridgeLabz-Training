package com.linkedlist.doublylinkedlist.undoredofunctionality;

import java.util.Scanner;

public class MainTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor(10); // max 10 states

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Type new text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display current text");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    System.out.println("Text added!");
                    break;
                case 2:
                    editor.undo();
                    editor.displayCurrent();
                    break;
                case 3:
                    editor.redo();
                    editor.displayCurrent();
                    break;
                case 4:
                    editor.displayCurrent();
                    break;
                case 5:
                    System.out.println("Exiting editor");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
