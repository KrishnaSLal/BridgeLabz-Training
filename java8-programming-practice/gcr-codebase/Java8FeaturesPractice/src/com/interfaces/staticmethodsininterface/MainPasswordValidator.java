package com.interfaces.staticmethodsininterface;

import java.util.Scanner;

public class MainPasswordValidator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Rule: Min 8 chars, 1 uppercase, 1 lowercase, 1 digit");
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println("Password is Strong");
        } else {
            System.out.println("Password is Weak");
            
        }

        sc.close();
    }
}
