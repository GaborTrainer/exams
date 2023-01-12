package uppercase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class UpperCaseLetters {

    public int getNumberOfUpperCase(Path path) {
        try (Stream<String> stream = Files.lines(path)) {
            return stream.mapToInt(this::processResult).sum();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private int processResult(String line) {
        return (int) Arrays.stream(line.split(""))
                .filter(s -> Character.isAlphabetic(s.charAt(0)) && s.equals(s.toUpperCase()))
                .count();
    }
}