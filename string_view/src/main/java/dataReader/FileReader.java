package dataReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {
    private static final String PATH = "string_view/src/main/resources/text.txt";
    private static File file = new File(PATH);
    private static StringBuilder data = new StringBuilder();


    public static String getData() {

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}
