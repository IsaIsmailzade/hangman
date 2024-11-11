import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    static String randomWord;
    static String wordAfter;
    static List<Character> usedLetters;
    static int attempts = 6;

    public static void start() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            randomWord = RandomWord.getRandomWord();

            int remainingLetters = randomWord.length();
            String[] wordMask = new String[randomWord.length()];
            Arrays.fill(wordMask, "*");
            wordAfter = "";

            usedLetters = new ArrayList<>();

            for (int i = 0; i < randomWord.length(); i++) {
                System.out.print("*");
            }

            System.out.println("\nВведите букву: ");
            while (remainingLetters > 0) {

                char letter = scanner.nextLine().charAt(0);

                if (usedLetters.contains(letter)) {
                    System.out.println("Вы уже вводили эту букву. Она неверна.");
                } else usedLetters.add(letter);

                boolean correctGuess = false;
                for (int i = 0; i < randomWord.length(); i++) {
                    if (Character.toLowerCase(randomWord.charAt(i)) == Character.toLowerCase(letter) && wordMask[i].equals("*")) {
                        wordMask[i] = String.valueOf(randomWord.charAt(i));
                        usedLetters.remove(Character.valueOf(letter));
                        remainingLetters--;
                        correctGuess = true;
                    }
                }

                int wrongLetters = usedLetters.size();
                if (!correctGuess) {
                    attempts = attempts - 1;
                    System.out.println("Упс, такой буквы нет..");
                    System.out.println("У вас осталось: " + attempts + " попыток");
                    Gallows.print(wrongLetters);
                }

                wordAfter = String.join("", wordMask);
                System.out.println(wordAfter);
                System.out.println("Использованные буквы: " + usedLetters);

                if (wrongLetters == 6) {
                    System.out.println("Вы проиграли.");
                    System.exit(0);
                } else if (remainingLetters == 0) System.out.println("Поздравляем! Вы выиграли!");

            }
        }
    }
}