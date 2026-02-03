package com.chatlogparser;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ChatLogReader {

    private static final Pattern CHAT_PATTERN =
        Pattern.compile("\\[(.*?)\\]\\s(.*?):\\s(.*)");

    public static List<Message> read(File file) throws IOException {

        List<Message> messages = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                Matcher matcher = CHAT_PATTERN.matcher(line);

                if (matcher.matches()) {
                    String time = matcher.group(1);
                    String user = matcher.group(2);
                    String text = matcher.group(3);

                    messages.add(new Message(time, user, text));
                }
            }
        }
        return messages;
    }
}
