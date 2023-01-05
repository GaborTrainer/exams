package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    @Test
    void testGreatestCommonDivisor() {
        assertEquals(3, new Algorithms().greatestCommonDivisor(3, 9));
        assertEquals(4, new Algorithms().greatestCommonDivisor(12, 8));
    }

    @Test
    void testGreatestCommonDivisorRelativePrimes() {
        assertEquals(1, new Algorithms().greatestCommonDivisor(2, 7));
    }
}