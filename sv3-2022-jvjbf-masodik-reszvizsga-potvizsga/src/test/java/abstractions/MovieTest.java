package abstractions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void testCreateMovieAsContent() {
        Content content = new Movie(new Video("Best movie", 123));

        assertEquals("Best movie", content.getTitle());
        assertEquals(123, content.getLength());
    }

    @Test
    void testAddVideo() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> new Movie(new Video("Best movie", 123)).addVideo(new Video("other", 121)));

        assertEquals("Cannot add more video for this type of content!", ise.getMessage());
    }
}