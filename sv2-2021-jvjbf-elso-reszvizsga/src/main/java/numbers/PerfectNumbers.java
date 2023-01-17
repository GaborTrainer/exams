package numbers;

import java.util.stream.IntStream;

public class PerfectNumbers {

    public boolean isPerfectNumber(int number) {
        return IntStream.range(1, number / 2 + 1)
                .filter(i -> number % i == 0)
                .sum() == number;
    }
}
