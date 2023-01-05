package algorithms;

import java.util.List;

public class Algorithms {

    public boolean isChainOfWords(List<String> words) {
        if (words.size() <= 1) {
            return false;
        }
        String actualWord = words.get(0);
        String lastChar = actualWord.substring(actualWord.length() - 1).toLowerCase();
        for (int i = 1; i < words.size(); i++) {
            actualWord = words.get(i);
            String firstChar = actualWord.substring(0, 1).toLowerCase();
            if (!firstChar.equals(lastChar)) {
                return false;
            }
            lastChar = actualWord.substring(actualWord.length() - 1).toLowerCase();
        }
        return true;
    }
}
