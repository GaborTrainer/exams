package algorithms;

import java.util.stream.IntStream;

public class Algorithms {

    public int greatestCommonDivisor(int firstNumber, int secondNumber) {
        return IntStream.rangeClosed(1, Math.min(firstNumber, secondNumber))
                .filter(i -> firstNumber % i == 0 && secondNumber % i == 0)
                .max()
                .orElse(0);
    }
}
