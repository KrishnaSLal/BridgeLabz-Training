/*13. Sandeep’s Fitness Challenge Tracker 🏋️
♂Each day Sandeep completes a number of push-ups.
● Store counts for a week.
● Use for-each to calculate total and average.
● Use continue to skip rest days.*/




public class FitnessChallengeTracker{

    // Constant for number of days in a week
    private static final int DAYS = 7;

    public static void main(String[] args) {

        // 0 indicates a rest day
        int[] dailyPushUps = {30, 0, 25, 40, 0, 35, 20};

        int totalPushUps = calculateTotalPushUps(dailyPushUps);
        double averagePushUps = calculateAveragePushUps(dailyPushUps);

        displayResults(totalPushUps, averagePushUps);
    }

    // Calculate total push-ups (skip rest days)
    private static int calculateTotalPushUps(int[] pushUps) {
        int total = 0;

        for (int count : pushUps) {
            if (count == 0) {
                continue; // Skip rest days
            }
            total += count;
        }

        return total;
    }

    // Calculate average push-ups (excluding rest days)
    private static double calculateAveragePushUps(int[] pushUps) {
        int total = 0;
        int workoutDays = 0;

        for (int count : pushUps) {
            if (count == 0) {
                continue; // Skip rest days
            }
            total += count;
            workoutDays++;
        }

        return workoutDays > 0 ? (double) total / workoutDays : 0;
    }

    // Display results
    private static void displayResults(int total, double average) {
        System.out.println("\nThe Fitness Challenge Summary of Sandeep:");
		System.out.println("-------------------------------------------");
        System.out.println("\nTotal Push-Ups (Workout Days Only): " + total);
        System.out.println("Average Push-Ups per Workout Day: " + average);
    }
}


