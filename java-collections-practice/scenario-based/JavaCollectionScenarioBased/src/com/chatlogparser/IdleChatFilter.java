package com.chatlogparser;

import java.util.*;

public class IdleChatFilter implements MessageFilter<Message> {

    private static final List<String> IDLE_KEYWORDS =
            Arrays.asList("lol", "brb", "haha", "ok", "bye");

    @Override
    public boolean filter(Message message) {
        String text = message.getText().toLowerCase();
        return IDLE_KEYWORDS.stream().noneMatch(text::contains);
    }
}
