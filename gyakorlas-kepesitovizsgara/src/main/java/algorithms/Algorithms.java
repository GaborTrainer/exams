package algorithms;

import java.util.List;

public class Algorithms {

    public List<Integer> aboveAverage(List<Integer> numbers) {
        double average = numbers.stream()
                .mapToInt(Integer::intValue).average()
                .orElse(0);
        return numbers.stream()
                .filter(n -> n > average)
                .toList();
    }
}
