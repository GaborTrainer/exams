package abstractions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextFileTest {

    @Test
    void testCreateTextFile() {
        TextFile txt = new TextFile("text");

        assertEquals("text", txt.getTitle());
        assertEquals(0, txt.getLines().size());
    }

    @Test
    void testGetFullName() {
        File file = new TextFile("text");

        assertEquals("text.txt", file.getFullName());
    }

    @Test
    void testAddLine() {
        TextFile textFile = new TextFile("text");

        textFile.addLine("This is a line");
        textFile.addLine("Tis is an other line");

        assertEquals(2, textFile.getLines().size());
    }

    @Test
    void testCalculateSize() {
        TextFile textFile = new TextFile("text");

        textFile.addLine("This is a line");
        textFile.addLine("Tis is an other line");

        assertEquals(0.002, textFile.calculateSize(), 0.001);
    }
}
