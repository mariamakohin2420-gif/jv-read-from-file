package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) throws IOException {

        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        List<String> result = new ArrayList<>();

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            String[] words = line.toLowerCase().split("[^a-z]+");

            for (String word : words) {
                if (!word.isEmpty() && word.startsWith("w")) {
                    result.add(word);
                }
            }
        }

        bufferedReader.close();

        Collections.sort(result);

        return result.toArray(new String[0]);
    }



}
