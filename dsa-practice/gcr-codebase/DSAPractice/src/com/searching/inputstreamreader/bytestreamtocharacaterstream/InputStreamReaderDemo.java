package com.inputstreamreader.bytestreamtocharacaterstream;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class InputStreamReaderDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter character encoding (e.g., UTF-8): ");
        String charsetName = scanner.nextLine();

        try (
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName(charsetName));
            BufferedReader br = new BufferedReader(isr)
        ) {
            String line;

            System.out.println("\n--- File Content ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding: " + charsetName);
        } catch (IOException e) {
            System.out.println("Error reading file.");
        } catch (Exception e) {
            System.out.println("Invalid charset name.");
        } finally {
            scanner.close();
        }
    }
}
