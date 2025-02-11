package task;

import java.util.Random;
import java.util.Scanner;

public class Numbering_game {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 5;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean playAgain;
        
        do {
            if (playRound(scanner)) {
                score++;
            }
            playAgain = askToPlayAgain(scanner);
        } while (playAgain);
        
        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }

    private static boolean playRound(Scanner scanner) {
        int targetNumber = generateRandomNumber();
        System.out.println("\nI have generated a number between " + MIN + " and " + MAX + ". Try to guess it!");

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            int guess = getUserGuess(scanner, attempt);
            
            if (guess == targetNumber) {
                System.out.println("🎉 Correct! You guessed the number.");
                return true;
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        
        System.out.println("Out of attempts! The number was " + targetNumber + ".");
        return false;
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX - MIN + 1) + MIN;
    }

    private static int getUserGuess(Scanner scanner, int attempt) {
        System.out.print("Attempt " + attempt + "/" + MAX_ATTEMPTS + ": Enter your guess: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next().trim().toLowerCase();
        return response.equals("yes");
    }
}
