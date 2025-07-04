import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    static int userAttempts = 0;

    public void hangmanGame() {

        String[] words = {"Hello", "Simple", "Hunter", "Bottles", "Hangman",
                "Six", "Monster", "Ghost"};

        // Assign random word that user will have to guess
        Random random = new Random();
        int randomNumber = random.nextInt(words.length);
        String randomWord;
        randomWord = words[randomNumber];
        randomWord = randomWord.toLowerCase();
        char[] randomWordArray = randomWord.toCharArray();
        char[] userGuessArray = new char[randomWordArray.length];
        Arrays.fill(userGuessArray, '_');


        int guessesAvailable = 7;
        Scanner scanner = new Scanner(System.in);
        char userInputGuessChar;

        System.out.println("Welcome to the Hangman game!");
        System.out.println("The word is " + randomWord.length() + " characters long, " +
                "and you have " + guessesAvailable  + " available guesses to get the word right! Good luck!");


        while (guessesAvailable > 0) {

            userInputGuessChar = userInput(scanner);

            guessesAvailable = checkIfUserGuessIsInWordToGuess(userInputGuessChar, randomWordArray, userGuessArray, guessesAvailable);

            printGameOver(guessesAvailable, randomWord);

            guessesAvailable = gameWon(randomWordArray, userGuessArray, guessesAvailable);
        }
    }

    private static int checkIfUserGuessIsInWordToGuess(char userInputGuessChar, char[] randomWordArray, char[] userGuessArray, int guessesAvailable) {
        if (contains(userInputGuessChar, randomWordArray)) {
            if (contains(userInputGuessChar, userGuessArray)) {
                System.out.println("You've already tried this letter, please try again: ");
                System.out.println("Correct word: " + new String(userGuessArray));
            } else {
               addRightGuessToUserGuessArray(randomWordArray, userInputGuessChar, userGuessArray);
               userAttempts++;
            }
        } else {
            guessesAvailable--;
            userAttempts++;
            System.out.println("Wrong! You now only have " + guessesAvailable + " guesses available");
            System.out.println("Correct word: " + new String(userGuessArray));
        }
        return guessesAvailable;
    }

    // Add correct user guess char to userGuessArray
    private static void addRightGuessToUserGuessArray(char[] randomWordArray, char userInputGuessChar, char[] userGuessArray) {
        for (int i = 0; i <= randomWordArray.length - 1; i++) {

            if (randomWordArray[i] == userInputGuessChar) {
                userGuessArray[i] = userInputGuessChar;

            }


        }

        System.out.println("Correct word: " + new String(userGuessArray));

    }

    private static int gameWon(char[] randomWordArray, char[] userGuessArray, int guessesAvailable) {
        if (Arrays.equals(randomWordArray, userGuessArray)) {
            String correctWord = new String(userGuessArray);
            System.out.println("Well done! You guessed the word " + correctWord + " in " + userAttempts + " attempts!");
            guessesAvailable = 0;
        }
        return guessesAvailable;
    }

    private static void printGameOver(int guessesAvailable, String randomWord) {
        if (guessesAvailable == 0) {
            System.out.println("Game Over! The word you were looking for was " + randomWord);
        }
    }

    // Method that takes input from user
    private static char userInput(Scanner scanner) {
        char userInputGuessChar = 0;
        String userInputGuess;
        boolean isUserInputValid = true;
        System.out.println("Please enter a letter: ");


        while (isUserInputValid) {

            userInputGuess = scanner.nextLine();
            if (userInputGuess.length() > 1) {
                System.out.println("Please enter only 1 character: ");
            } else if (userInputGuess.isEmpty()) {
                System.out.println("You didn't enter a character, please try again: ");
            } else {
                userInputGuessChar = userInputGuess.toLowerCase().charAt(0);
                isUserInputValid = false;
            }

        }

        return userInputGuessChar;

    }

    private static boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }
}