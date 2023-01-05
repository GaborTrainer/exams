package abstractions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeaderTest {

    @Test
    void testCreateHeader() {
        Header header = new Header("Important", 10);

        assertEquals("Important", header.getTitle());
        assertEquals(10, header.getHeaderSize());
    }
}