package abstractions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PictureTest {

    @Test
    void testCreatePicture() {
        Picture picture = new Picture("picture", "jpg", 120, 100);

        assertEquals("picture", picture.getTitle());
        assertEquals("jpg", picture.getExtension());
        assertEquals(120, picture.getWidth());
        assertEquals(100, picture.getLength());
    }

    @Test
    void testGetFullName() {
        File file = new Picture("picture", "jpg", 120, 100);

        assertEquals("picture.jpg", file.getFullName());
    }

    @Test
    void testCalculateSize() {
        File file = new Picture("picture", "jpg", 120, 100);

        assertEquals(12.0, file.calculateSize(), 0.0001);
    }
}
