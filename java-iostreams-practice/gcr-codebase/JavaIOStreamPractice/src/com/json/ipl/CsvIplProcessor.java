package com.json.ipl;

import java.io.*;

public class CsvIplProcessor {

    public static void main(String[] args) {

        String input = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\json\\ipl\\ipl_input.csv";
        String output = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamPractice\\src\\com\\json\\ipl\\ipl_censored.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output))
        ) {

            String line = br.readLine(); // header
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                d[1] = CensorUtil.maskTeamName(d[1]); // team1
                d[2] = CensorUtil.maskTeamName(d[2]); // team2
                d[5] = CensorUtil.maskTeamName(d[5]); // winner
                d[6] = CensorUtil.redactPlayer();     // player

                bw.write(String.join(",", d));
                bw.newLine();
            }

            System.out.println("Censored CSV generated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
