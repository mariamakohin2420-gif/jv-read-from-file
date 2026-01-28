package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        String[] line = new String[]{};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            line = bufferedReader.readLine().split("\\W+");

            while (line != null) {
                for (String word : line) {
                    if (word.toLowerCase().startsWith("w")) {
                        builder.append(word);
                    }

                }
                line = bufferedReader.readLine();


            }
            System.out.println(Arrays.toString(line));
        } catch (RuntimeException e) {

        }
        return line;
    }
}