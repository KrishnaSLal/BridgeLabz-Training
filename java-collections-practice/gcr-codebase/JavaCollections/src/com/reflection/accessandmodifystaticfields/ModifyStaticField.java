package com.reflection.accessandmodifystaticfields;

import java.lang.reflect.Field;
import java.util.Scanner;

public class ModifyStaticField {

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Take user input
            System.out.print("Enter new API KEY: ");
            String newApiKey = scanner.nextLine();

            // Load class dynamically (fully qualified name)
            Class<?> clazz =
                    Class.forName("com.reflection.accessandmodifystaticfields.Configuration");

            // Access private static field
            Field field = clazz.getDeclaredField("API_KEY");
            field.setAccessible(true);

            // Get original value (static → null)
            String oldKey = (String) field.get(null);
            System.out.println("Old API_KEY: " + oldKey);

            // Modify static field
            field.set(null, newApiKey);

            // Get updated value
            String updatedKey = (String) field.get(null);
            System.out.println("Updated API_KEY: " + updatedKey);

        } catch (ClassNotFoundException e) {
            System.out.println("Configuration class not found!");
        } catch (NoSuchFieldException e) {
            System.out.println("API_KEY field not found!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
