import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class RandomWord extends Main {

    public static String getRandomWord() throws IOException {
        Random random = new Random();
        Path path = Path.of("words.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            int randomNum = random.nextInt(100);

            return bufferedReader.lines()
                    .toList()
                    .get(randomNum);
        }
    }
}
