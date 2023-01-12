package adddigits;

public class AddDigits {
    public int addDigits(String input) {
        if (input == null || input.isEmpty()) {
            return -1;
        }
        return input.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sum();
    }
}
