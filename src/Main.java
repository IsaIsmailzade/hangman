import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String start;

        System.out.println("[Н]овая игра или [В]ыйти");
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                start = scanner.nextLine();

                if (start.equals("Н") || start.equals("н")) {
                    Game.start(scanner);
                } else if (start.equals("В") || start.equals("в")) {
                    scanner.close();
                    System.exit(0);
                } else System.out.println("Попробуйте снова");
            }
        }
    }
}