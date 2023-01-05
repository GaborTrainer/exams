package numbers;

import java.util.List;

public class RisingNumbers {

    public int getNumberOfSixDigitRisingNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("There are no numbers!");
        }
            int count = 0;
        for (Integer number : numbers) {
            String numString = number.toString();
            if (numString.length() != 6) {
                continue;
            }
            boolean isRising = true;
            for (int i = 0; i < numString.length() - 1; i++) {
                if (numString.charAt(i) >= numString.charAt(i + 1)) {
                    isRising = false;
                    break;
                }
            }
            if (isRising) {
                count++;
            }
        }
        return count;
    }
}
