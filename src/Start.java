import java.io.IOException;
import java.util.Scanner;

public class Start {

    public static void takeLetter() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n[Н]овая игра или [В]ыйти");
                String start = scanner.nextLine();
                if (start.equalsIgnoreCase("н")) {
                    Game.start(scanner);
                } else if (start.equalsIgnoreCase("в")) {
                    scanner.close();
                    System.exit(0);
                } else System.out.println("Попробуйте снова");
            }
        }
    }
}
