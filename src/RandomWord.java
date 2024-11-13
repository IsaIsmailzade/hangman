import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class RandomWord extends Main {

    public static String getRandomWord() throws IOException {
        Random random = new Random();
        Path path = Path.of("words.txt");

        List<String> words;
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            words = bufferedReader.lines().toList();
        }

        if (words.isEmpty()) {
            throw new IOException("В файле нет слов");
        }

        int randomNum = random.nextInt(words.size());
        return words.get(randomNum);
    }
}
