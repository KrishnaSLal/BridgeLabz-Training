//4. FlashDealz – Product Sorting by Discount (Quick Sort)
//Story: An e-commerce platform runs a flash sale with millions of products, each offering
//different discounts. Users want to see the top discounted products instantly. To quickly sort
//such large data, the backend uses Quick Sort, known for its fast average-case performance
//and efficiency.
//Concepts Involved:
//● Quick Sort
//● Large unsorted data
//● Performance optimization

package com.flashdealz;

import java.util.Scanner;

public class MainFlashDealz{
   public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        Products[] products = new Products[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Enter the details of product: " + (i + 1));

            System.out.print("Product Name: ");
            String name = sc.next();

            System.out.print("Price: ");
            float price = sc.nextFloat();

            System.out.print("Discount: ");
            float discount = sc.nextFloat();
            System.out.println("---------------------------------");
            products[i] = new Products(name, price, discount);
        }

        TopDiscountedProducts.quickSort(products, 0, products.length - 1);
       
        
        System.out.println("\nProducts Sorted by Discount (High to Low): \n");
        for (Products p : products) {
            System.out.println(p);
        }

        sc.close();
    }
}
