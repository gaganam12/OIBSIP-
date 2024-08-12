import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int totalRounds = 3; // Number of rounds
        int score = 0; // Initialize score
        Random random = new Random();

        for (int round = 1; round <= totalRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0; // Attempts counter
            boolean hasGuessedCorrectly = false;

            JOptionPane.showMessageDialog(null, "Round " + round + ": Guess the number between 1 and 100!");

            while (attempts < 10 && !hasGuessedCorrectly) { // Limit to 10 attempts
                String userInput = JOptionPane.showInputDialog("Enter your guess:");
                if (userInput == null) {
                    JOptionPane.showMessageDialog(null, "Game cancelled.");
                    return; // Exit the game if the user cancels
                }

                try {
                    int userGuess = Integer.parseInt(userInput);
                    attempts++;

                    if (userGuess < 1 || userGuess > 100) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100.");
                    } else if (userGuess < numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Higher! Try again.");
                    } else if (userGuess > numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Lower! Try again.");
                    } else {
                        hasGuessedCorrectly = true;
                        JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                        score += (10 - attempts); // Points based on attempts
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }

            if (!hasGuessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry! You've used all attempts. The number was: " + numberToGuess);
            }
        }

        JOptionPane.showMessageDialog(null, "Game Over! Your total score is: " + score);
    }
}