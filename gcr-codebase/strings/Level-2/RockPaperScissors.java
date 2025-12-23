import java.util.Scanner;

public class RockPaperScissors{

    // Method to generate computer choice using Math.random()
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);

        if (choice == 0)
            return "rock";
        else if (choice == 1)
            return "paper";
        else
            return "scissors";
    }

    // Method to find winner
    // Returns "User", "Computer", or "Draw"
    public static String findWinner(String user, String computer) {

        if (user.equals(computer))
            return "Draw";

        if (user.equals("rock") && computer.equals("scissors") ||
            user.equals("paper") && computer.equals("rock") ||
            user.equals("scissors") && computer.equals("paper")) {
            return "User";
        }

        return "Computer";
    }

    // Method to calculate stats and percentage
    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {

        String[][] stats = new String[2][3];

        double userPercent = (userWins * 100.0) / totalGames;
        double computerPercent = (computerWins * 100.0) / totalGames;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerPercent);

        return stats;
    }

    // Method to display game results and stats
    public static void displayResults(String[][] games, String[][] stats) {

        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\tComputer\tWinner");

        for (int i = 0; i < games.length; i++) {
            System.out.println((i + 1) + "\t" +games[i][0] + "\t" +games[i][1] + "\t\t" +games[i][2]);
        }

        System.out.println("\nFinal Statistics:");
        System.out.println("Player\tWins\tWinning %");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" +
                               stats[i][1] + "\t" +
                               stats[i][2] + "%");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[][] gameResults = new String[n][3];

        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < n; i++) {

            System.out.print("Enter your choice (rock/paper/scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                computerWins++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, n);
        displayResults(gameResults, stats);

        scanner.close();
    }
}