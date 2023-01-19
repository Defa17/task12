package task.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadFromFile {
    public static String loadFromFile(String inputFile) throws FileNotFoundException {
        final File file = new File(inputFile);
        String str;
        try (final Scanner scanner = new Scanner(file)){
            str = scanner.nextLine();
        }
        return str;
    }


}
