import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
        // boolean char array to count occurrences of char in char array
        boolean[] booleanArray = new boolean[randomWord.length()];

        System.out.println(randomWordArray);



        int guessesAvailable = randomWord.length();
        Scanner scanner = new Scanner(System.in);
        String userInputGuess;
        char userInputGuessChar;

        System.out.println("Welcome to the Hangman game!");
        System.out.println("The word is " + guessesAvailable + " characters long, " +
                "meaning you have " + guessesAvailable  + " available guesses");


        while (guessesAvailable > 0) {


            System.out.println("Please enter a letter: ");

            userInputGuess = scanner.nextLine();
            userInputGuessChar = userInputGuess.charAt(0);

            if (contains(userInputGuessChar, randomWordArray)) {
                if (contains(userInputGuessChar, userGuessArray)) {
                    System.out.println("You've already tried this letter, please try again: ");
                } else {
                for (int i = 0; i <= randomWordArray.length - 1; i++) {


                    if (randomWordArray[i] == userInputGuessChar) {
                        userGuessArray[i] = userInputGuessChar;
                        System.out.println(userGuessArray);

                    }

                }
                }
            } else {
                guessesAvailable--;
                System.out.println("Wrong! You now only have " + guessesAvailable + " guesses available");
            }

            if (guessesAvailable == 0) {
                System.out.println("Game Over!");
            }

            if (Arrays.equals(randomWordArray, userGuessArray)) {
                System.out.println("Well done! You guessed the word " + Arrays.toString(userGuessArray));
                guessesAvailable = 0;
            }
        }





        }


    static boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }
    }



