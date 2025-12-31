/*16. Digital Watch Simulation ⏱️
Simulate a 24-hour watch:
● Print hours and minutes in a nested for-loop.
● Use a break to stop at 13:00 manually (simulate power cut).
Core Java Scenario Based Problem Statements*/




public class DigitalWatchSimulation {

    public static void main(String[] args) {

        for (int hour = 0; hour < 24; hour++) {

            for (int minute = 0; minute < 60; minute++) {

                // Simulate power cut at 13:00
                if (hour == 13 && minute == 0) {
                    System.out.println("Power Cut at 13:00!");
                    break;
                }

                // Format time as HH:MM
                System.out.printf("%02d:%02d\n", hour, minute);
            }

            // Exit outer loop after power cut
            if (hour == 13) {
                break;
            }
        }
    }
}
