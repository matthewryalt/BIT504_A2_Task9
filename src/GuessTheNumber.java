import java.util.Scanner;

public class GuessTheNumber {

    // Clears the console screen (works in most terminals)
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Splash screen with ASCII art
    public static void splashScreen() {
        System.out.println("  ____                     _   _                 _               ");
        System.out.println(" / ___| ___   ___   ___   | \\ | | ___  _ __ ___ | |__   ___ _ __ ");
        System.out.println("| |  _ / _ \\ / _ \\ / _ \\  |  \\| |/ _ \\| '_ ` _ \\| '_ \\ / _ \\ '__|");
        System.out.println("| |_| | (_) | (_) | (_) | | |\\  | (_) | | | | | | |_) |  __/ |   ");
        System.out.println(" \\____|\\___/ \\___/ \\___/  |_| \\_|\\___/|_| |_| |_|_.__/ \\___|_|   ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("        Choose your difficulty and guess the number!");
        System.out.println("----------------------------------------------------------------\n");
    }

    // Victory screen with celebratory message
    public static void victoryScreen(int attempts) {
        System.out.println("\n*DING!* 🎯 YOU NAILED IT!");
        System.out.println("You guessed the number in " + attempts + " attempts!");
        System.out.println("Thanks for playing Guess the Number!");
        System.out.println("----------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearScreen();
        splashScreen();

        // Difficulty selection
        System.out.println("Select difficulty level:");
        System.out.println("1. Easy (1–100)");
        System.out.println("2. Medium (1–500)");
        System.out.println("3. Hard (1–1024)");
        System.out.print("Enter choice (1-3): ");
        int choice = scanner.nextInt();

        int maxRange;
        switch (choice) {
            case 1: maxRange = 100; break;
            case 2: maxRange = 500; break;
            case 3: maxRange = 1024; break;
            default:
                System.out.println("Invalid choice. Defaulting to Hard.");
                maxRange = 1024;
        }

        int numberToGuess = (int) (Math.random() * maxRange) + 1;
        int userGuess = 0;
        int attempts = 0;

        clearScreen();
        System.out.println("I've picked a number between 1 and " + maxRange + ". Try to guess it!\n");

        // Main game loop
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("*BUZZ!* ❌ Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("*BUZZ!* ❌ Too high! Try again.");
            } else {
                clearScreen();
                victoryScreen(attempts);
                break;
            }

            // Clear screen and encourage every 5 attempts
            if (attempts % 5 == 0) {
                clearScreen();
                System.out.println("You're still in the game! Attempts so far: " + attempts);
                System.out.println("Keep going, you're getting closer!\n");
            }
        }

        scanner.close();
    }
}
