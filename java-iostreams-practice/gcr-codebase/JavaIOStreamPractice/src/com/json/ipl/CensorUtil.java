package com.json.ipl;
public class CensorUtil {

    public static String maskTeamName(String team) {
        return team.split(" ")[0] + " ***";
    }

    public static String redactPlayer() {
        return "REDACTED";
    }
}
