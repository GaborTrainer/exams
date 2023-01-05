package lettermultiplier;

public class LetterMultiplier {

    public String multiply(String input, int number) {
        if (input == null || input.isEmpty() || number < 0) {
            throw new IllegalArgumentException();
        }

        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char aChar : chars) {
            while (count < number) {
                sb.append(aChar);
                count++;
            }
            count = 0;
        }
        return sb.toString();
    }
}