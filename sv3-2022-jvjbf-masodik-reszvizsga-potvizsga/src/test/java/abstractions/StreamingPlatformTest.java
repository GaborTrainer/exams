package abstractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamingPlatformTest {

    StreamingPlatform streamingPlatform = new StreamingPlatform();

    @BeforeEach
    void init() {
        streamingPlatform.addContent(new Movie(new Video("Best movie", 123)));
        streamingPlatform.addContent(new Movie(new Video("Best movie 2", 124)));
        streamingPlatform.addContent(new Series("Best series", new Video("First part", 61)));
        streamingPlatform.addContent(new Movie(new Video("Best movie 3", 127)));

        streamingPlatform.getContents().get(2).addVideo(new Video("Second part", 72));
    }

    @Test
    void testCreateStreamingPlatform() {
        StreamingPlatform sp = new StreamingPlatform();
        assertEquals(0, sp.getContents().size());
    }

    @Test
    void testAddContent() {
        assertEquals(4, streamingPlatform.getContents().size());
    }

    @Test
    void testFindLongestContent() {
        Content content = streamingPlatform.findLongestContent();

        assertEquals("Best series", content.getTitle());
    }

    @Test
    void testFindLongestWithEmptyList() {
        assertThrows(IllegalStateException.class,
                () -> new StreamingPlatform().findLongestContent());
    }
}