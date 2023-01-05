package movietheatres;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class MovieTheatreService {

    private Map<String, List<Movie>> shows = new LinkedHashMap<>();

    public void readFromFile(Path path) {
        try (Scanner s = new Scanner(path)) {
            while (s.hasNext()) {
                String line = s.nextLine();
                processLine(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file!");
        }
    }

    private void processLine(String line) {
        String[] temp = line.split("-");
        String[] movie = temp[1].split(";");
        if (!shows.containsKey(temp[0])) {
            shows.put(temp[0], new ArrayList<>());
        }
        shows.get(temp[0]).add(new Movie(movie[0], LocalTime.parse(movie[1])));
        shows.get(temp[0]).sort(Comparator.comparing(Movie::getStartTime));
    }

    public Map<String, List<Movie>> getShows() {
        return shows;
    }

    public List<String> findMovie(String title) {
        return shows.entrySet().stream()
                .filter(e -> e.getValue().stream()
                        .anyMatch(m -> m.getTitle().equals(title)))
                .map(Map.Entry::getKey).toList();
    }

    public LocalTime findLatestShow(String title) {
        return shows.entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .filter(m -> m.getTitle().equals(title)).max(Comparator.comparing(Movie::getStartTime))
                .orElseThrow(()-> new IllegalArgumentException("Cannot find movie!"))
                .getStartTime();
    }
}