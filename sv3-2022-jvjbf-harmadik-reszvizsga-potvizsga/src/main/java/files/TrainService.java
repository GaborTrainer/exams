package files;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class TrainService {

    private Map<String, List<Train>> schedule = new TreeMap<>();

    public Map<String, List<Train>> getSchedule() {
        return new TreeMap<>(schedule);
    }

    public void readFromFile(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                processLine(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file: " + path);
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(";");
        String city = temp[0];
        String[] train = temp[1].split(" ");
        TrainType trainType = TrainType.valueOf(train[1]);
        LocalTime time = LocalTime.parse(train[2]);
        if (!schedule.containsKey(city)) {
            schedule.put(city, new ArrayList<>());
        }
        schedule.get(city).add(new Train(train[0], trainType, time));
    }

    public String findCityWithMostTrains() {
       return schedule.entrySet().stream()
                .max(Comparator.comparing(v -> v.getValue().size()))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalStateException("Data structure is empty!"));
    }

    public String findDestinationByTrainId(String trainId) {
        return schedule.entrySet().stream()
                .filter(e -> e.getValue().stream().anyMatch(train -> train.getId().equals(trainId)))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find train with id: " + trainId));
    }

    public List<LocalTime> findDeparturesToCity(String city) {
        if (!schedule.containsKey(city)) {
            throw new IllegalArgumentException("City is not in schedule: " + city);
        }

        return schedule.get(city).stream()
                .map(Train::getDepartureTime)
                .sorted()
                .toList();
    }
}
