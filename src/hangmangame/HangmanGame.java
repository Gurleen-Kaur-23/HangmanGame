/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hangmangame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Gurleen Kaur
 */
public class HangmanGame {
    private final int MAX_ATTEMPTS = 6;

    private String secretWord;
    private String currentWord;

    private int attemptsLeft;

    private ArrayList<Character> guessedLetters;

    private final String[] words = {
        "apple",
        "banana",
        "cherry",
        "grape",
        "kiwi"
    };

    public HangmanGame() {
        guessedLetters = new ArrayList<>();
        startNewGame();
    }

    // Start a new game
    public void startNewGame() {

        Random random = new Random();

        secretWord =
                words[random.nextInt(words.length)];

        StringBuilder hiddenWord =
                new StringBuilder();

        for (int i = 0; i < secretWord.length(); i++) {
            hiddenWord.append("_");
        }

        currentWord = hiddenWord.toString();

        attemptsLeft = MAX_ATTEMPTS;

        guessedLetters.clear();
    }

    // Guess a letter
    public boolean guessLetter(char letter) {

        letter = Character.toLowerCase(letter);

        // Already guessed
        if (guessedLetters.contains(letter)) {
            return false;
        }

        guessedLetters.add(letter);

        boolean correct = false;

        StringBuilder updatedWord =
                new StringBuilder(currentWord);

        for (int i = 0; i < secretWord.length(); i++) {

            if (secretWord.charAt(i) == letter) {

                updatedWord.setCharAt(i, letter);

                correct = true;
            }
        }

        currentWord =
                updatedWord.toString();

        if (!correct) {
            attemptsLeft--;
        }

        return correct;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public ArrayList<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public boolean isWon() {
        return currentWord.equals(secretWord);
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0;
    }

    public int getWrongAttempts() {
        return MAX_ATTEMPTS - attemptsLeft;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreen().setVisible(true);
            }
        });
    }
    
}
