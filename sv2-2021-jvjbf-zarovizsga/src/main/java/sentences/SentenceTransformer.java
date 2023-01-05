package sentences;

import java.util.List;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {
        String firstLetterOfSentence = sentence.trim().substring(0, 1);
        String lastLetterOfSentence = sentence.trim().substring(sentence.length() - 1);
        if (!firstLetterOfSentence.equals(firstLetterOfSentence.toUpperCase())) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        if (!lastLetterOfSentence.matches("[.!?]")) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
        List<String> separatedSentence = List.of(sentence.trim().split(" "));
        if (separatedSentence.size() > 4) {
            return separatedSentence.get(0) + " ... " + separatedSentence.get(separatedSentence.size() - 1);
        }
        return sentence;
    }
}
