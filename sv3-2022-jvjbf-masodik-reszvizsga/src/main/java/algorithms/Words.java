package algorithms;

import java.util.List;

public class Words {

    public int countWordsStartsWithUpperCase(List<String> words) {
        return (int) words.stream()
                .filter(w -> Character.isUpperCase(w.charAt(0)))
                .count();
    }
}
