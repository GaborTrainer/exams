package algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SentencesTest {

    @Test
    void testCountEndsWithSentenceEnding() {
        List<String> input = List.of(
                "This is a sentence",
                "This is an other!",
                "Another?",
                "This ends with point.",
                "This is not ends with anything");

        Sentences sentences = new Sentences();
        assertEquals(3, sentences.countEndsWithSentenceEnding(input));
    }
}