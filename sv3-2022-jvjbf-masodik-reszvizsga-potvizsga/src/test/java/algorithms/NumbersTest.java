package algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void testIsPairInListWithSumOf() {
        Numbers numbers = new Numbers();
        assertTrue(numbers.isPairInListWithSumOf(List.of(1, 7, 2, 8, 3, 5), 5));
        assertTrue(numbers.isPairInListWithSumOf(List.of(1, 7, 2, 8, -2, 5), 5));
        assertFalse(numbers.isPairInListWithSumOf(List.of(1, 7, 2, 7, 8, 5), 5));
    }
}