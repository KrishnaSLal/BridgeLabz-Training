package com.dealtracker;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.*;

public class DealReader {

    private static final Pattern CODE_PATTERN =
            Pattern.compile("DealCode:\\s*(\\w+)");
    private static final Pattern DATE_PATTERN =
            Pattern.compile("ValidTill:\\s*(\\d{2}-\\d{2}-\\d{4})");
    private static final Pattern DISCOUNT_PATTERN =
            Pattern.compile("Discount:\\s*(\\d+)%");
    private static final Pattern MIN_PATTERN =
            Pattern.compile("MinimumPurc?hase:\\s*(\\d+)", Pattern.CASE_INSENSITIVE);

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // multiple deals from ONE file
    public static List<Deal> readDeals(File file) throws IOException {

        List<Deal> deals = new ArrayList<>();
        List<String> block = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    parseBlock(block, deals);
                    block.clear();
                } else {
                    block.add(line);
                }
            }
            parseBlock(block, deals); // last deal
        }
        return deals;
    }

    private static void parseBlock(List<String> block, List<Deal> deals) {

        if (block.isEmpty()) return;

        try {
            String content = String.join("\n", block);

            Matcher codeM = CODE_PATTERN.matcher(content);
            Matcher dateM = DATE_PATTERN.matcher(content);
            Matcher discM = DISCOUNT_PATTERN.matcher(content);
            Matcher minM = MIN_PATTERN.matcher(content);

            if (!(codeM.find() && dateM.find() && discM.find() && minM.find()))
                return;

            LocalDate validTill =
                    LocalDate.parse(dateM.group(1), FORMATTER);

            if (validTill.isBefore(LocalDate.now())) {
                System.out.println("Skipping file - Expired deal: " + codeM.group(1));
                return;
            }

            deals.add(new Deal(
                    codeM.group(1),
                    validTill,
                    Integer.parseInt(discM.group(1)),
                    Integer.parseInt(minM.group(1))
            ));

        } catch (Exception ignored) {}
    }
}
