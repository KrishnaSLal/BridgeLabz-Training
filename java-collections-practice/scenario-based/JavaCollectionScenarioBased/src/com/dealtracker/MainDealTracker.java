//DealTracker – E-Commerce Discount Validator
//Story: An e-commerce platform is flooded with daily deals, sent in a file like:
//DealCode: FLAT50
//ValidTill: 15-06-2025
//Discount: 50%
//MinimumPurchase: 999
//The DealTracker tool should:
//● Read and parse .txt deal entries using FileInputStream
//● Use Regex to extract fields like percentage and date
//● Filter expired deals using LocalDate + regex validation
//● Store all valid deals in a Map<String, Deal>
//● Use a Set to prevent duplicate deal codes
//● Allow sorting deals by discount using Comparator
//● Use Generics to work with other promotion types: cashback, referral bonus, etc.

package com.dealtracker;

import java.io.File;
import java.util.*;

public class MainDealTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter deals folder path: ");
        File folder = new File(sc.nextLine());

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("❌ Invalid folder path!");
            return;
        }

        Map<String, Deal> dealMap = new HashMap<>();
        Set<String> dealCodes = new HashSet<>();

        try {
            for (File file : Objects.requireNonNull(folder.listFiles())) {

                if (file.getName().endsWith(".txt")) {

                    List<Deal> deals = DealReader.readDeals(file);

                    for (Deal deal : deals) {
                        if (dealCodes.add(deal.getCode())) {
                            dealMap.put(deal.getCode(), deal);
                        }
                    }
                }
            }

            List<Deal> sortedDeals = new ArrayList<>(dealMap.values());
            sortedDeals.sort(
                    Comparator.comparingInt(Deal::getDiscountValue).reversed());

            System.out.println("\nValid Deals (Sorted by Discount):");

            if (sortedDeals.isEmpty()) {
                System.out.println("No valid deals found.");
            } else {
                sortedDeals.forEach(System.out::println);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
