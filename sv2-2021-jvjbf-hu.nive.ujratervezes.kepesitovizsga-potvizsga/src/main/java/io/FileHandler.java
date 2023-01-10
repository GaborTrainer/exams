package io;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileHandler {


    public int sumIgnoreComments(String path) {
        try (Scanner scanner = new Scanner(Path.of(path))){
            int result = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                result += processLine(line);
            }
            return result;
        } catch (IOException ioe) {
            throw new IllegalStateException();
        }
    }

    private int processLine(String line) {
        int sum = 0;
        if (Character.isDigit(line.charAt(0))) {
            sum += Integer.parseInt(line);
        }
        return sum;
    }
}
