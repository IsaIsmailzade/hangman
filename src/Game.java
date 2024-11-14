import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public static void start(Scanner scanner) throws IOException {
        String randomWord = RandomWord.getRandomWord();
        final String MASK_SYMBOL = "*";
        int attempts = 6;

//        System.out.println(randomWord);

        Set<Character> usedLetters = new HashSet<>();
        StringBuilder currentWord = new StringBuilder();
        currentWord.append(MASK_SYMBOL.repeat(randomWord.length()));

        System.out.println("\n" + currentWord);

        while (attempts > 0) {
            System.out.println("\nВведите букву: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.length() != 1) {
                System.out.println("Введите одну букву.");
                continue;
            }

            char letter = input.charAt(0);
            if (!Character.isLetter(letter) || letter < 'а' || letter > 'я') {
                System.out.println("Необходимо ввести букву русского алфавита.");
                continue;
            }

            if (usedLetters.contains(letter)) {
                System.out.println("Вы уже вводили эту букву. Введите другую букву.");
                continue;
            }

            usedLetters.add(letter);
            boolean correctGuess = false;
            for (int i = 0; i < randomWord.length(); i++) {
                if (Character.toLowerCase(randomWord.charAt(i)) == letter && currentWord.charAt(i) == MASK_SYMBOL.charAt(0)) {
                    currentWord.setCharAt(i, randomWord.charAt(i));
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts--;
                System.out.println("\nУпс, такой буквы нет...");
                System.out.println("У вас осталось: " + attempts + " попыток");
                Gallows.print(6 - attempts);
            }

            System.out.println("Использованные буквы: " + usedLetters);
            System.out.println("\n" + currentWord);

            if (attempts == 0) {
                System.out.println("Вы проиграли. Слово было: " + randomWord);
                break;
            } else if (currentWord.toString().equalsIgnoreCase(randomWord)) {
                System.out.println("Поздравляем! Вы выиграли!");
                break;
            }
        }
    }
}
