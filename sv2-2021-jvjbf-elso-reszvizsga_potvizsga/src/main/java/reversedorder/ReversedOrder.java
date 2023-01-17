package reversedorder;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReversedOrder {

    public String getWordsInReversedOrder(String[] words) {
        return IntStream.range(0, words.length)
                .mapToObj(i -> words[words.length - 1 - i])
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        ReversedOrder reversedOrder = new ReversedOrder();

        System.out.println(reversedOrder.getWordsInReversedOrder(new String[]{"alma", "körte", "barack"})); // barack, körte, alma
    }
}
