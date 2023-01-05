package algorithms;

import java.util.List;

public class Sentences {

    public int countEndsWithSentenceEnding(List<String> sentences) {
        int count = 0;
        for (String sentence : sentences) {
            if (sentence.endsWith("!") || sentence.endsWith("?") || sentence.endsWith(".")) {
                count++;
            }
        }
        return count;
    }
}
