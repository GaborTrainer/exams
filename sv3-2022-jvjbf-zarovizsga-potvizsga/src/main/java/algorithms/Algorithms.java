package algorithms;

import java.util.List;
import java.util.OptionalInt;

public class Algorithms {


    public int countMaximums(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty!");
        }
        OptionalInt max = numbers.stream().mapToInt(i -> i).max();
        return (int) numbers.stream().filter(i -> i == max.getAsInt()).count();
    }
}
