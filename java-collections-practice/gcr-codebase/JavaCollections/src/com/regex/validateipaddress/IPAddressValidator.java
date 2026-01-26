package com.regex.validateipaddress;

import java.util.Scanner;

public class IPAddressValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IPv4 address: ");
        String ip = sc.nextLine();

        String regex = "\\b((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"+ "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\b";

        if (ip.matches(regex)) {
            System.out.println("Valid IP address");
        } else {
            System.out.println("Invalid IP address");
        }

        sc.close();
    }
}
