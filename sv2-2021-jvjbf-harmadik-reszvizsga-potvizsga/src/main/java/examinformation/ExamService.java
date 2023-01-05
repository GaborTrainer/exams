package examinformation;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class ExamService {

    private Map<String, ExamResult> results = new TreeMap<>();

    private ExamResult maxPoints;

    public void readFromFIle(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            String[] firstLine = scanner.nextLine().split(" ");
            maxPoints = new ExamResult(Integer.parseInt(firstLine[0]), Integer.parseInt(firstLine[1]));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                processLine(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file: " + path);
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(";");
        String[] points = temp[1].split(" ");
        results.put(temp[0], new ExamResult(Integer.parseInt(points[0]), Integer.parseInt(points[1])));
    }

    public int getTheoryMax() {
        return maxPoints.getTheory();
    }

    public int getPracticeMax() {
        return maxPoints.getPractice();
    }

    public Map<String, ExamResult> getResults() {
        return results;
    }

    public List<String> findPeopleFailed() {
        return results.entrySet().stream()
                .filter(exam -> exam.getValue().getPractice() < (getPracticeMax() * 0.51) || exam.getValue().getTheory() < (getTheoryMax() * 0.51))
                .map(Map.Entry::getKey)
                .toList();
    }

    public String findBestPerson() {
        return results.entrySet().stream()
                .filter(exam -> !findPeopleFailed().contains(exam.getKey()))
                .max(Comparator.comparing(exam -> exam.getValue().getMaxPoints()))
                .orElseThrow(() -> new IllegalStateException("Didn't find the best!")).getKey();
    }
}
