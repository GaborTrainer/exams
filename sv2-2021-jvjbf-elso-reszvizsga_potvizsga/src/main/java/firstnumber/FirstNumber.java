package firstnumber;

public class FirstNumber {

    public char getFirstNumber(String s) {
        char[] c = s.toCharArray();
        for (char value : c) {
            if (Character.isDigit(value)) {
                return value;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FirstNumber firstNumber = new FirstNumber();

        System.out.println(firstNumber.getFirstNumber("This is a String")); // a konzolon ilyenkor egy üres sor látszik
        System.out.println(firstNumber.getFirstNumber("Thi3s is4 a St5ring")); // 3
    }
}
