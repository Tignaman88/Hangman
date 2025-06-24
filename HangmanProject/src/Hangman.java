import java.util.Random;
import java.util.Scanner;

public class Hangman {

    String[] words = {"Hello", "Simple", "Hunter", "Bottles", "Hangman",
    "Six", "Monster", "Ghost"};

    public String randomWord() {
        // Assign random word that user will have to guess
        Random random = new Random();
        int randomNumber = random.nextInt(words.length);
        String randomWord;
        randomWord = words[randomNumber];
        return randomWord;
    }

    int randomWordLength = randomWord().length();
    int guessesAvailable = randomWordLength;

    Scanner scanner = new Scanner(System.in);
    String userInputGuess;
    String userGuess = "";

    public void printGuessesAvailable() {

        System.out.println("Welcome to the Hangman game!");
        System.out.println("The word is " + randomWordLength + " characters long, " +
                "meaning you have " + guessesAvailable  + " available guesses");
    }

    public String playingTheGame() {

        System.out.println("Please enter a letter: ");
        userInputGuess = scanner.nextLine();
        if (randomWord().contains(userInputGuess)) {

            userGuess += userInputGuess;
        } else {
            guessesAvailable--;
            System.out.println("The word doesn't contain the letter selected, you have " +
                    guessesAvailable + " guesses available left");
        }

        return userGuess;
    }



    @Override
    public String toString() {
        return "Hangman{" +
                "randomWord='" + randomWord() + '\'' +
                '}';
    }
}
