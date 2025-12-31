/*17. Online Quiz Application 🧠
Ask 5 questions (MCQs) from a user.
● Use arrays and for-loop.
● Record score.
● Switch for answer checking. Apply clear indentation and structured layout.*/




import java.util.Scanner;

public class OnlineQuizApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] questions = {
                "1. What is the size of int in Java?",
                "2. Which keyword is used to inherit a class?",
                "3. Which loop is guaranteed to run at least once?",
                "4. What is the default value of boolean?",
                "5. Which method is the entry point of Java program?"
        };

        String[][] options = {
                {"a) 2 bytes", "b) 4 bytes", "c) 8 bytes", "d) Depends on OS"},
                {"a) implement", "b) extends", "c) inherits", "d) super"},
                {"a) for", "b) while", "c) do-while", "d) foreach"},
                {"a) true", "b) false", "c) null", "d) 0"},
                {"a) start()", "b) run()", "c) main()", "d) execute()"}
        };

        char[] correctAnswers = {'b', 'b', 'c', 'b', 'c'};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {

            System.out.println(questions[i]);

            for (int j = 0; j < options[i].length; j++) {
                System.out.println(options[i][j]);
            }

            System.out.print("Enter your answer (a/b/c/d): ");
            char userAnswer = scanner.next().toLowerCase().charAt(0);

            switch (userAnswer) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                    if (userAnswer == correctAnswers[i]) {
                        score++;
                        System.out.println("Correct answer\n");
                    } else {
                        System.out.println("Wrong answer\n");
                    }
                    break;

                default:
                    System.out.println("Invalid choice\n");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your Score: " + score + " / " + questions.length);

        scanner.close();
    }
}