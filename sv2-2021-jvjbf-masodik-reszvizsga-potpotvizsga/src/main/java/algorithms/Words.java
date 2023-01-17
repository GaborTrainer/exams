package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public void addWords(String word, String ... more) {
        words.add(word);
        words.addAll(Arrays.asList(more));
    }

    public List<String> findWordsOccursOnes(){
        return words.stream()
                .filter(word -> words.indexOf(word) == words.lastIndexOf(word))
                .toList();
    }

    public List<String> getWords() {
        return words;
    }
}
