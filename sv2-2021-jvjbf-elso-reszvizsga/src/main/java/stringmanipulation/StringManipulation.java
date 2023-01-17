package stringmanipulation;

import java.util.stream.IntStream;

public class StringManipulation {

    public String everyEvenCharacter(String s) {
        return IntStream.range(0, s.length())
                .filter(i -> i % 2 == 0)
                .mapToObj(s::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        StringManipulation stringManipulation = new StringManipulation();
        System.out.println(stringManipulation.everyEvenCharacter("This is a String"));
    }
}
