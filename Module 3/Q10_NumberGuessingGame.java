import java.util.Scanner;
import java.util.Random;

public class Q10_NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess;

        System.out.println("Guess the number (between 1 and 100):");

        while (true) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                break;
            }
        }

        scanner.close();
    }
}

