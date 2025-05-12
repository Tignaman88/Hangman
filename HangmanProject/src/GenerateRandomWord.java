import java.util.Random;

public class GenerateRandomWord {

    String[] words = {"Hello", "Simple", "Hunter", "Bottles", "Hangman",
    "Six", "Monster", "Ghost"};

    Random random = new Random();
    int randomNumber = random.nextInt(words.length);
    String randomWord = words[randomNumber];

    
}
