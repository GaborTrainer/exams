package files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class WeatherService {

    private Map<LocalDate, List<WeatherMeasurement>> measurements = new TreeMap<>();

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot reach file!", e);
        }
    }

    public LocalDate findDateWithMostMeasurements() {
        return measurements.entrySet().stream()
                .max(Comparator.comparing(e -> e.getValue().size()))
                .orElseThrow(() -> new IllegalStateException("Empty data structure!")).getKey();
    }

    public int findTemperatureByDateAndTime(LocalDate date, LocalTime time) {
        if (!measurements.containsKey(date)) {
            throw new IllegalArgumentException("Date not in data structure: " + date);
        }

        return measurements.get(date).stream()
                .filter(m -> m.getTime().equals(time))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No time on that day: " + time))
                .getCelsiusDegree();
    }

    public List<LocalTime> findMeasurementsByDate(LocalDate date) {
        if (!measurements.containsKey(date)) {
            throw new IllegalArgumentException("Date not in data structure: " + date);
        }

        return measurements.get(date).stream()
                .map(WeatherMeasurement::getTime)
                .toList();
    }

    private void processLine(String line) {
        String[] temp = line.split(";");
        String[] weatherData = temp[1].split(" ");
        WeatherMeasurement weatherMeasurement = new WeatherMeasurement(LocalTime.parse(weatherData[0]), Integer.parseInt(weatherData[1]));
        updateMeasurements(LocalDate.parse(temp[0]), weatherMeasurement);
    }

    private void updateMeasurements(LocalDate date, WeatherMeasurement weatherMeasurement) {
        measurements.computeIfAbsent(date, k -> new ArrayList<>()).add(weatherMeasurement);
        measurements.get(date).sort(Comparator.comparing(WeatherMeasurement::getTime));
    }

    public Map<LocalDate, List<WeatherMeasurement>> getMeasurements() {
        return new TreeMap<>(measurements);
    }
}