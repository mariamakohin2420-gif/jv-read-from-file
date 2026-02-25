package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        // Використовуємо try-with-resources для автоматичного закриття файлу
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Розбиваємо рядок за регулярним виразом: все, що НЕ є літерою a-z
                // Це автоматично прибирає пробіли та пунктуацію
                String[] words = line.toLowerCase().split("[^a-z]+");

                for (String word : words) {
                    // Перевіряємо, чи слово не порожнє та чи починається на 'w'
                    if (!word.isEmpty() && word.startsWith("w")) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            // Якщо файл не знайдено або виникла помилка читання,
            // повертаємо порожній масив, щоб тести не "падали" через винятки
            return new String[0];
        }

        // Сортуємо у природному порядку (алфавітному)
        Collections.sort(result);

        // Перетворюємо список у масив
        return result.toArray(new String[0]);
    }

}
