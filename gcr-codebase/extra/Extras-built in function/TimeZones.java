import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZones{

    // Method to display current time in a given zone
    public static void displayTime(String zoneName, String zoneId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(zoneId));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy HH:mm:ss z");
        System.out.println(zoneName + " : " + zonedDateTime.format(formatter));
    }

    public static void main(String[] args) {
        System.out.println("Current Time in Different Zones");

        // GMT (Greenwich Mean Time)
        displayTime("GMT", "GMT");

        // IST (Indian Standard Time)
        displayTime("IST", "Asia/Kolkata");

        // PST (Pacific Standard Time)
        displayTime("PST", "America/Los_Angeles");
    }
}