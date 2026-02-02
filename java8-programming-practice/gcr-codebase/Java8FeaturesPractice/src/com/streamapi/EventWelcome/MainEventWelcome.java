//Event Attendee Welcome Message
//○ Scenario: Print a welcome message for all attendees.
//○ Task: Use forEach() with a lambda.


package com.streamapi.EventWelcome;

import java.util.*;

public class MainEventWelcome {
    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
                "Krishna", "Anita", "Arushi", "Minakshi"
        );

        attendees.forEach(name ->
                System.out.println("Welcome to the event, " + name + "!")
        );
    }
}