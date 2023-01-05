package words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordsTest {

    Words words = new Words();

    @Test
    void testDeleteEvenCharacters(){
        assertEquals("la", words.deleteEvenCharacters("alma"));
    }
    
    @Test
    void testDeleteEvenCharactersTwoLetterWord(){
        assertEquals("a",words.deleteEvenCharacters("fa"));
    }

    @Test
    void testDeleteEvenCharactersOneLetterWord(){
        assertEquals("",words.deleteEvenCharacters("a"));
    }

    @Test
    void testDeleteEvenCharactersEmptyWord(){
        assertEquals("",words.deleteEvenCharacters(""));
    }

}