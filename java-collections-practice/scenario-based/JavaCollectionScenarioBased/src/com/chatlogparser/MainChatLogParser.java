// ChatLogParser – Messaging Pattern Analyzer
//Story: A company wants to analyze employee chat logs for productivity. The logs are stored in
//plain text files like:
//[12:02 PM] John: Hey, the build failed again!
//[12:03 PM] Mary: I’ll check the Jenkins pipeline.
//Your task is to build ChatLogParser, a tool that:
//● Reads chat logs using BufferedReader
//● Uses Regex to extract timestamp, user, and message
//● Stores results in a Map<String, List<String>> (user → messages)
//● Filters out “idle chat” based on keyword list ("lol", "brb", etc.)
//● Uses TreeMap to automatically sort users alphabetically
//● Supports generic filtering rules using interfaces like MessageFilter<T>
 
 package com.chatlogparser;

import java.io.File;
import java.util.*;

public class MainChatLogParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter chat log file path: ");
        File file = new File(sc.nextLine());

        if (!file.exists()) {
            System.out.println("File not found!");
        }

        try {
            List<Message> messages = ChatLogReader.read(file);
            MessageFilter<Message> filter = new IdleChatFilter();

            Map<String, List<String>> chatMap = new TreeMap<>();

            for (Message msg : messages) {
                if (filter.filter(msg)) {
                    chatMap
                        .computeIfAbsent(msg.getUser(), k -> new ArrayList<>())
                        .add(msg.getText());
                }
            }

            System.out.println("\nProductive Messages:");
            chatMap.forEach((user, msgs) -> {
                System.out.println("\n" + user + ":");
                msgs.forEach(m -> System.out.println(" - " + m));
            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
