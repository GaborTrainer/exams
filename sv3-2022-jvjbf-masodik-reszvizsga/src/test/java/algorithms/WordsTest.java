package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordsTest {

    @Test
    void testCountWordsStartsWithUpperCase() {
        Words words = new Words();
        List<String> input = Arrays.asList("Apple tree", "beer", "Tree", "cup", "forest");

        assertEquals(2, words.countWordsStartsWithUpperCase(input));
    }
}