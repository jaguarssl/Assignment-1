import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to Jude's number guessing game!");
        System.out.println("I am thinking of a number between 1 and 100. Good luck :)");

        Scanner scanner = new Scanner(System.in);

        int hiddenNumber = (int) (Math.random() * 100) + 1;
        int guess = 0;

        while (guess != hiddenNumber) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
        }

        System.out.println("You got it!");
        scanner.close();
    }
}
