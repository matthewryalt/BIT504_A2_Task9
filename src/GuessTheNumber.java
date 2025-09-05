import java.util.Scanner;

public class GuessTheNumber {

    // Method to simulate clearing the screen
    public static void clearScreen() {
        // ANSI escape code to clear screen and move cursor to top-left
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = (int) (Math.random() * 1024) + 1;
        int userGuess = 0;
        int attempts = 0;

        clearScreen(); // Clear screen at the start
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("--------------");
        System.out.println("I have chosen a number between 1 and 1024. Can you guess it?");
        System.out.println("--------------");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                clearScreen(); // Clear screen before final message
                System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            }

            // Clear screen every 5 attempts to keep things tidy
            if (attempts % 5 == 0) {
                clearScreen();
                System.out.println("Keep going! You're doing great.");
                System.out.println("Attempts so far: " + attempts);
            }
        }

        scanner.close();
    }
}
