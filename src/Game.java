import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    static String randomWord;
    static String wordAfter;
    static List<Character> usedLetters;
    static int attempts;

    public static void start(Scanner scanner) throws IOException {
        attempts = 6;
        randomWord = RandomWord.getRandomWord();
//        System.out.println(randomWord);

        int remainingLetters = randomWord.length();
        String[] wordMask = new String[randomWord.length()];
        Arrays.fill(wordMask, "*");
        wordAfter = "";

        usedLetters = new ArrayList<>();

        for (int i = 0; i < randomWord.length(); i++) {
            System.out.print("*");
        }

        System.out.println("\nВведите букву: ");
        while (remainingLetters >= 0) {

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
                System.out.println("\nУпс, такой буквы нет..");
                System.out.println("У вас осталось: " + attempts + " попыток");
                Gallows.print(wrongLetters);
            }

            System.out.println("Неправильные буквы: " + usedLetters);
            wordAfter = String.join("", wordMask);
            System.out.println("\n" + wordAfter);

            if (wrongLetters == 6) {
                System.out.println("Вы проиграли.");
                break;
            } else if (remainingLetters == 0) {
                System.out.println("Поздравляем! Вы выиграли!");
                break;
            }
        }
    }
}