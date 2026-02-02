//4. Email Notifications
//Given a list of user emails, use forEach() to send a notification email to each user.

package com.streamapi.emailnotification;


import java.util.*;

public class MainEmailNotification {
    public static void main(String[] args) {

        List<String> userEmails = Arrays.asList(
                "krishna@gmail.com",
                "anita@yahoo.com",
                "suresh@hotmail.com",
                "meena@gmail.com"
        );

        // Sending notifications
        userEmails.forEach(email ->
                System.out.println("Notification sent to: " + email)
        );
    }
}
