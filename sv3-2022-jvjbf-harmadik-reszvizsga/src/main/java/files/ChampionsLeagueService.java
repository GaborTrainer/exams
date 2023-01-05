package files;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ChampionsLeagueService {

    private Map<String, List<LocalDate>> schedule = new TreeMap<>();

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
        String[] dates = temp[0].split("-");
        String[] clubs = temp[1].split("-");
        if (!schedule.containsKey(clubs[0])) {
            schedule.put(clubs[0], new ArrayList<>());
        }
        if (!schedule.containsKey(clubs[1])) {
            schedule.put(clubs[1], new ArrayList<>());
        }
        schedule.get(clubs[0]).add(LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])));
        schedule.get(clubs[1]).add(LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])));
    }

    public Map<String, List<LocalDate>> getSchedule() {
        return schedule;
    }

    public Set<LocalDate> collectPlayDays() {
        Set<LocalDate> result = new HashSet<>();
        for (List<LocalDate> localDate : schedule.values()) {
            result.addAll(localDate);
        }
        return result;
    }

    public Set<String> findTeamsByDay(LocalDate date) {
        return schedule.entrySet().stream()
                .filter(e -> e.getValue().contains(date))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public String findTeamWithMostPlayedMatches() {
        return schedule.entrySet().stream()
                .max(Comparator.comparing(e -> e.getValue().size()))
                .map(Map.Entry::getKey)
                .get();
    }
}
