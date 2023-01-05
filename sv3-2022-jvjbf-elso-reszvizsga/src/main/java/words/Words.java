package words;

public class Words {

    public String deleteEvenCharacters(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < word.length(); i += 2) {
            result.append(word.charAt(i));
        }
        return result.toString();
    }
}
