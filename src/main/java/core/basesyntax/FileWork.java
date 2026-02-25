package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        // try-with-resources автоматично закриває потік
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("[^a-z]+");
                for (String word : words) {
                    if (!word.isEmpty() && word.startsWith("w")) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            // Повертаємо порожній масив, якщо файл не знайдено або неможливо прочитати
            return new String[0];
        }

        Collections.sort(result);
        return result.toArray(new String[0]);

    }
}
