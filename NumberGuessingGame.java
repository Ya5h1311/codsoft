import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean hasWon = false;

            System.out.println("I have chosen a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts. Let's begin!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    hasWon = true;
                    totalScore += (maxAttempts - attempts + 1) * 10; // Scoring based on remaining attempts
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (!hasWon) {
                System.out.println("Sorry! You've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your total score: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score: " + totalScore);
        scanner.close();
    }
}

