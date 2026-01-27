package com.annotations.roleallowed;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MainRoleAllowed {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your role (ADMIN / USER): ");
            String userRole = scanner.nextLine().toUpperCase();

            Class<AdminService> clazz = AdminService.class;

            // Check if @RoleAllowed is present
            if (clazz.isAnnotationPresent(RoleAllowed.class)) {

                RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);
                String requiredRole = roleAllowed.value();

                if (!userRole.equals(requiredRole)) {
                    System.out.println("Access Denied!");
                    return;
                }
            }

            // Access granted → invoke method
            AdminService service = new AdminService();
            Method method = clazz.getMethod("deleteUser");
            method.invoke(service);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
