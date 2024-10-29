import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("Words.txt");
        System.out.println("[N]ew game or [E]xit");

        try (Scanner scanner = new Scanner(System.in);
             BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String start = scanner.nextLine();
            String word = bufferedReader.readLine();

            if (start.equals("N") || start.equals("n")) {
                System.out.println(word);
                System.out.println("Введите букву: ");
                String letter = scanner.nextLine();
            }
        }
    }
}