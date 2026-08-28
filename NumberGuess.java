import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to Jude's number guessing game!");
        System.out.println("I am thinking of a number between 1 and 100. Good luck :)");

        Scanner scanner = new Scanner(System.in);

        int hiddenNumber = (int) (Math.random() * 100) + 1;
        int count = 0;
        int guess = 0;

        while (guess != hiddenNumber) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            count++;

            canedoGuess g = new canedoGuess(guess, count);
            System.out.println(g.hint(hiddenNumber));
        }

        System.out.println("Solved in " + count + " attempts.");
        scanner.close();
    }

    public static class canedoGuess {
        int value;
        int guessedNumber;

        canedoGuess(int value, int guessedNumber) {
            this.value = value;
            this.guessedNumber = guessedNumber;
        }

        String hint(int hiddenNumber) {
            if (value > hiddenNumber) {
                return "Attempt " + guessedNumber + ": " + value + " is too high";
            } else if (value < hiddenNumber) {
                return "Attempt " + guessedNumber + ": " + value + " is too low";
            } else {
                return "Attempt " + guessedNumber + ": " + value + " is correct!";
            }
        }
    }
}
