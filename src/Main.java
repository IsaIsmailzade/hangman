import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String start;

        System.out.println("[Н]овая игра или [В]ыйти");
        try (Scanner scanner = new Scanner(System.in)) {
            start = scanner.nextLine();

            if (start.equals("Н") || start.equals("н")) {
                Game.start();
            } else if (start.equals("В") || start.equals("в")) {
                scanner.close();
            } else System.out.println("Попробуйте снова");
        }
    }
}