import java.io.*;
import java.util.concurrent.*;

public class SimpleQuiz{
    static int score = 0;
    static int totalQuestions = 5;
    static int time = 10;

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the Quiz!");

        System.out.println("\nYou have " + time + " seconds for each question.");
        System.out.println("Answer quickly and wisely. Good luck!\n");

        for (int i = 1; i <= totalQuestions; i++) {
            String question = "";
            String[] options = new String[4];
            String correctAnswer = "";

            switch (i) {
                case 1:
                    question = "What is the capital of France?";
                    options = new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"};
                    correctAnswer = "3";
                    break;
                case 2:
                    question = "Which is the largest planet in our Solar System?";
                    options = new String[]{"1. Earth", "2. Jupiter", "3. Mars", "4. Venus"};
                    correctAnswer = "2";
                    break;
                case 3:
                    question = "Who wrote 'Romeo and Juliet'?";
                    options = new String[]{"1. Charles Dickens", "2. William Shakespeare", "3. Mark Twain", "4. J.K. Rowling"};
                    correctAnswer = "2";
                    break;
                case 4:
                    question = "What is the square root of 64?";
                    options = new String[]{"1. 6", "2. 8", "3. 10", "4. 12"};
                    correctAnswer = "2";
                    break;
                case 5:
                    question = "What is the chemical symbol for water?";
                    options = new String[]{"1. O2", "2. H2O", "3. CO2", "4. HO"};
                    correctAnswer = "2";
                    break;
            }

            System.out.println(i + ". " + question);
            for (String option : options) {
                System.out.println(option);
            }

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> future = executor.submit(() -> {
                System.out.print("Your answer: ");
                return reader.readLine().trim();
            });

            try {
                String answer = future.get(time, TimeUnit.SECONDS);
                if (answer.equals(correctAnswer)) {
                    score++;
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Wrong! The correct answer was " + correctAnswer + ".\n");
                }
            } catch (TimeoutException e) {
                System.out.println("Time is up! Moving to the next question.\n");
                future.cancel(true);
            }

            executor.shutdownNow();
        }

        System.out.println("Your final score is: " + score + "/" + totalQuestions);
        displayResult();
    }

    public static void displayResult() {
        if (score == totalQuestions) {
            System.out.println("Perfect score! Well done!");
        } else if (score >= totalQuestions / 2) {
            System.out.println("Good job! But there's room for improvement.");
        } else {
            System.out.println("Better luck next time!");
        }
    }
}
