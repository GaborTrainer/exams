package numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    Numbers numbers = new Numbers();

    @Test
    void sumOfPositiveEvenNumbers(){
        assertEquals(12, numbers.sumOfPositiveEvenNumbers(Arrays.asList(-1,3,4,8,-12)));
        assertEquals(0, numbers.sumOfPositiveEvenNumbers(Arrays.asList(-1,3,-9,123567)));
    }

}