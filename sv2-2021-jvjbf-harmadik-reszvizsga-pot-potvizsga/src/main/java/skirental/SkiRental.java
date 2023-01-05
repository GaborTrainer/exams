package skirental;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class SkiRental {

    private Map<String, Equipment> rentals = new TreeMap<>();

    public Map<String, Equipment> getRentals() {
        return new TreeMap<>(rentals);
    }

    public void loadFromFile(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            String[] firstLine = scanner.nextLine().split(" ");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                processLine(line);
            }
        } catch (IllegalStateException | IOException ise) {
            throw new IllegalStateException("Cannot read file: " + path);
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(";");
        String[] sizes = temp[1].split(" ");
        rentals.put(temp[0], new Equipment(Integer.parseInt(sizes[0]), Integer.parseInt(sizes[1])));
    }

    public List<String> listChildren() {
        return rentals.entrySet().stream()
                .filter(equipment -> equipment.getValue().getSizeOfSkis() < 121 && equipment.getValue().getSizeOfBoot() < 38)
                .map(Map.Entry::getKey)
                .toList();
    }

    public String getNameOfPeopleWithBiggestFoot() {
        return rentals.entrySet().stream()
                .filter(equipment -> equipment.getValue().getSizeOfSkis() != 0)
                .max(Comparator.comparingInt(equipment -> equipment.getValue().getSizeOfBoot()))
                .map(Map.Entry::getKey)
                .orElseThrow();
    }
}

