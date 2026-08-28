import java.util.Scanner;

// Final complete version: guessing loop, hint feedback, and high/low guess statistics
public class NumberGuess {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to Jude's number guessing game!");
        System.out.println("I am thinking of a number between 1 and 100. Good luck :)");

        Scanner scanner = new Scanner(System.in);

        int hiddenNumber = (int) (Math.random() * 100) + 1;
        int[] guesses = new int[100];
        int count = 0;
        int guess = 0;

        while (guess != hiddenNumber) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            guesses[count] = guess;
            count++;

            canedoGuess g = new canedoGuess(guess, count);
            System.out.println(g.hint(hiddenNumber));
        }

        System.out.println("Solved in " + count + " attempts.");
        int high = countHighGuesses(guesses, count, hiddenNumber);
        System.out.println("You guessed too high " + high + " times.");
        int low = countLowGuesses(guesses, count, hiddenNumber);
        System.out.println("You guessed too low " + low + " times.");
        scanner.close();
    }

    static int countHighGuesses(int[] arr, int count, int hiddenNumber) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > hiddenNumber) {
                total = total + 1;
            }
        }
        return total;
    }

    static int countLowGuesses(int[] arr, int count, int hiddenNumber) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] < hiddenNumber) {
                total = total + 1;
            }
        }
        return total;
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
