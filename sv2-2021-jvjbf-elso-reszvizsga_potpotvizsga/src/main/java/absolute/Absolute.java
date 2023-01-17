package absolute;

import java.util.stream.IntStream;

public class Absolute {

    public boolean isAbsolute(int number) {
        return IntStream.range(1, number / 2 + 1)
                .filter(i -> number % i == 0)
                .sum() == number;
    }

    public static void main(String[] args) {
        Absolute absolute = new Absolute();

        System.out.println(absolute.isAbsolute(6)); //true
        System.out.println(absolute.isAbsolute(8128)); //true
        System.out.println(absolute.isAbsolute(7246)); //false
        System.out.println(absolute.isAbsolute(9)); //false
    }
}
