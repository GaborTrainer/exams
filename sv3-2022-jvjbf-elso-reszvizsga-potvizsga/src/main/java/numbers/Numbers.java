package numbers;

import java.util.List;

public class Numbers {

    public int sumOfPositiveEvenNumbers(List<Integer> numbers) {
//        int result = 0;
//        for (Integer i : numbers) {
//            if (i > 0 && i % 2 == 0) {
//                result += i;
//            }
//        }
//        return result;
        return numbers.stream()
                .filter(i -> i > 0 && i % 2 == 0)
                .reduce(0, Integer::sum);
    }
}
