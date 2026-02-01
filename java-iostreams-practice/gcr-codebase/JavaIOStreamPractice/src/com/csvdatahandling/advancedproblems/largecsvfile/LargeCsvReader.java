package com.csvdatahandling.advancedproblems.largecsvfile;

import java.io.*;
import java.util.*;

public class LargeCsvReader {

    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\csvdatahandling\\advancedproblems\\largecsvfile\\largefile.csv";

        int totalRecords = 0;
        List<String> chunk = new ArrayList<>(CHUNK_SIZE);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            
            br.readLine();

            while ((line = br.readLine()) != null) {

                chunk.add(line);

                if (chunk.size() == CHUNK_SIZE) {
                    totalRecords += processChunk(chunk);
                    chunk.clear(); 
                }
            }

          
            if (!chunk.isEmpty()) {
                totalRecords += processChunk(chunk);
                chunk.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total records processed: " + totalRecords);
    }

   
    private static int processChunk(List<String> lines) {
        
        return lines.size();
    }
}
