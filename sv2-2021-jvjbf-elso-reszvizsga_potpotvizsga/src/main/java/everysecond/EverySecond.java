package everysecond;

import java.util.stream.IntStream;

public class EverySecond {

    public String getEverySecondLetter(String s) {
        return IntStream.range(0, s.length())
                .filter(i -> i % 2 == 0)
                .mapToObj(s::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        EverySecond everySecond = new EverySecond();

        System.out.println(everySecond.getEverySecondLetter("This is a String")); //Ti saSrn
    }
}
