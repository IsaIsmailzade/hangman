import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("Words.txt");
        System.out.println("[Н]овая игра или [В]ыйти");

        try (Scanner scanner = new Scanner(System.in);
             BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String start = scanner.nextLine();
            String word = bufferedReader.readLine();

            if (start.equals("Н") || start.equals("н")) {
                int remainingLetters = word.length();
                String[] s = new String[word.length()];
                Arrays.fill(s, "*");
                String wordAfter = "";

                for (int i = 0; i < word.length(); i++) {
                    System.out.print("*");
                }

                System.out.println("\nВведите букву: ");
                while (remainingLetters > 0) {

                    String letter = scanner.nextLine();
                    for (int i = 0; i < word.length(); i++) {

                        if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(letter.charAt(0))) {
                            s[i] = String.valueOf(word.charAt(i));
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