package algorithms;

import java.util.List;

public class Numbers {

    public boolean isPairInListWithSumOf(List<Integer> numbers, int value) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 1; j < numbers.size() - 1; j++) {
                count = numbers.get(i) + numbers.get(j);
                if (count == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
