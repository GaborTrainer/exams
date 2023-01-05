package numbers;

import java.util.stream.IntStream;

public class ArmstrongNumbers {

    public boolean isArmstrongNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number can't be negative: " + number);
        }
        int pow = String.valueOf(number).length();
        return number == IntStream.iterate(number, i -> i / 10)
                .limit(pow)
                .map(i -> (int) Math.pow(i % 10, pow))
                .sum();
    }
}
