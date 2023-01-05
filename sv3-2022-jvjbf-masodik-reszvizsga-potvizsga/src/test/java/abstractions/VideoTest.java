package abstractions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoTest {

    @Test
    void testCreateVideo() {
        Video video = new Video("Best movie", 123);

        assertEquals("Best movie", video.getTitle());
        assertEquals(123, video.getLength());
    }
}