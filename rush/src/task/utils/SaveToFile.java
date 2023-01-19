package task.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveToFile {
    public static void saveToFile(String outputFile, String answer) throws FileNotFoundException {
        final File file = new File(outputFile);
        try (final PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.print("Ответ: \n" + answer);
        }
    }
}
