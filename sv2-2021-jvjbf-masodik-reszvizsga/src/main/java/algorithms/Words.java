package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public void addWord(String word) throws IllegalArgumentException {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        if (!word.equals(word.toLowerCase())) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        return words.stream()
                .anyMatch(word -> Collections.frequency(words, word) > 1);
    }

    public List<String> getWords() {
        return words;
    }
}