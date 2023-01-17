package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sentences {

    private List<String> sentences = new ArrayList<>();

    public void addSentence(String sentence){
        if (!Character.isUpperCase(sentence.charAt(0))){
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        if (!(sentence.substring(sentence.length() - 1).matches("[.!?]"))){
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
        sentences.add(sentence);
    }

    public String findLongestSentence() {
        return sentences.stream()
                .max(Comparator.comparing(String::length))
                .orElseThrow(IllegalStateException::new);
    }

    public List<String> getSentences() {
        return sentences;
    }
}
