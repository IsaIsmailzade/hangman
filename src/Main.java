import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String start;
        String randomWord;
        String wordAfter;
        int remainingTries;

        System.out.println("[Н]овая игра или [В]ыйти");

        try (Scanner scanner = new Scanner(System.in)) {
            start = scanner.nextLine();
            randomWord = RandomWordSelector.getRandomWord();
            
            if (start.equals("Н") || start.equals("н")) {
                int remainingLetters = randomWord.length();
                String[] s = new String[randomWord.length()];
                Arrays.fill(s, "*");
                wordAfter = "";

                for (int i = 0; i < randomWord.length(); i++) {
                    System.out.print("*");
                }

                System.out.println("\nВведите букву: ");
                while (remainingLetters > 0) {

                    String letter = scanner.nextLine();
                    for (int i = 0; i < randomWord.length(); i++) {

                        if (Character.toLowerCase(randomWord.charAt(i)) == Character.toLowerCase(letter.charAt(0))) {
                            s[i] = String.valueOf(randomWord.charAt(i));
                            wordAfter = String.join("", s);
                            remainingLetters--;
                        }
                    }
                    System.out.println(wordAfter);
                }
            }
        }
    }
}