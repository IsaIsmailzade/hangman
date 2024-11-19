import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public static void start(Scanner scanner) throws IOException {
        final String MASK_SYMBOL = "*";
        int attempts = 6;
        Set<Character> usedLetters = new HashSet<>();
        String randomWord = RandomWord.getRandomWord();
        StringBuilder currentWord = new StringBuilder(MASK_SYMBOL.repeat(randomWord.length()));

//        System.out.println(randomWord);

        System.out.println("\n" + currentWord);

        while (attempts > 0) {
            System.out.println("\nВведите букву: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (isValidInput(input)) continue;

            char letter = input.charAt(0);
            if (isRussianLetter(letter) || isRepeatLetter(usedLetters, letter)) continue;

            usedLetters.add(letter);
            boolean correctGuess = updateCurrentWord(randomWord, letter, currentWord, MASK_SYMBOL);

            if (!correctGuess) {
                attempts--;
                printAttemptStatus(attempts);
            }

            printGameStatus("Использованные буквы: " + usedLetters, "\n" + currentWord);

            if (checkGameEnd(attempts, randomWord, currentWord)) break;
        }
    }

    private static void printGameStatus(String usedLetters, String currentWord) {
        System.out.println(usedLetters);
        System.out.println(currentWord);
    }

    private static boolean checkGameEnd(int attempts, String randomWord, StringBuilder currentWord) {
        if (attempts == 0) {
            System.out.println("Вы проиграли. Слово было: " + randomWord);
            return true;
        } else if (currentWord.toString().equalsIgnoreCase(randomWord)) {
            System.out.println("Поздравляем! Вы выиграли!");
            return true;
        }
        return false;
    }

    private static void printAttemptStatus(int attempts) {
        printGameStatus("\nУпс, такой буквы нет...", "У вас осталось: " + attempts + " попыток");
        Gallows.print(6 - attempts);
    }

    private static boolean updateCurrentWord(String randomWord, char letter, StringBuilder currentWord, String MASK_SYMBOL) {
        boolean correctGuess = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if (Character.toLowerCase(randomWord.charAt(i)) == letter && currentWord.charAt(i) == MASK_SYMBOL.charAt(0)) {
                currentWord.setCharAt(i, randomWord.charAt(i));
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    private static boolean isRepeatLetter(Set<Character> usedLetters, char letter) {
        if (usedLetters.contains(letter)) {
            System.out.println("Вы уже вводили эту букву. Введите другую букву.");
            return true;
        }
        return false;
    }

    private static boolean isRussianLetter(char letter) {
        if (!Character.isLetter(letter) || letter < 'а' || letter > 'я') {
            System.out.println("Необходимо ввести букву русского алфавита.");
            return true;
        }
        return false;
    }

    private static boolean isValidInput(String input) {
        if (input.length() != 1) {
            System.out.println("Введите одну букву.");
            return true;
        }
        return false;
    }
}
