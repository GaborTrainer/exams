package sumofdigits;

public class SumOfDigits {

    public int getSumOfDigits(int number) {
        return Integer.toString(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public static void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();

        System.out.println(sumOfDigits.getSumOfDigits(123456)); // 21
        System.out.println(sumOfDigits.getSumOfDigits(83)); // 11
        System.out.println(sumOfDigits.getSumOfDigits(987)); // 24
    }
}
