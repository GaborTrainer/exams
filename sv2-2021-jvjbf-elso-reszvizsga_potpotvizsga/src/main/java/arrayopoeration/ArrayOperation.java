package arrayopoeration;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayOperation {

    public String getWordsBackwards(String[] words) {
        return IntStream.range(0, words.length)
                .mapToObj(i -> words[words.length - 1 - i])
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        ArrayOperation arrayOperation = new ArrayOperation();

        System.out.println(arrayOperation.getWordsBackwards(new String[]{"alma", "körte", "barack"})); // barack, körte, alma
    }
}
