package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(this::processLine);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(";");
        humans.add(new Human(temp[0], temp[1]));
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, getMales());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private List<String> getMales() {
        return humans.stream()
                .filter(Human::isMale)
                .map(Human::toString)
                .toList();
    }

    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }
}
