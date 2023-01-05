package abstractions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @Test
    void testCreateSeriesAsContentWithFirstPart() {
        Content content = new Series("Rings of Power", new Video("First part", 62));

        assertEquals("Rings of Power", content.getTitle());
        assertEquals(62, content.getLength());
        assertEquals(1, ((Series) content).getVideos().size());
    }

    @Test
    void testCreateSeriesAsContentWithAllParts() {
        Content content = new Series("Mini series",
                List.of(new Video("First part", 62),
                        new Video("Second part", 46),
                        new Video("Third part", 48)));

        assertEquals("Mini series", content.getTitle());
        assertEquals(156, content.getLength());
        assertEquals(3, ((Series) content).getVideos().size());
    }

    @Test
    void testAddVideo() {
        Content content = new Series("Mini series",
                new ArrayList<>(List.of(new Video("First part", 62),
                        new Video("Second part", 46),
                        new Video("Third part", 48))));

        content.addVideo(new Video("Fourth Part", 52));

        assertEquals(4, ((Series) content).getVideos().size());
    }
}