package videos;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VideoTest {

    @Test
    void createVideo() {
        Video video = new Video("Best video", LocalDate.of(2022, 11, 11), 12,Type.DOCUMENTARY);

        assertEquals("Best video", video.getTitle());
        assertEquals(LocalDate.of(2022, 11, 11), video.getUploadTime());
        assertEquals(12, video.getLength());
        assertEquals(Type.DOCUMENTARY,video.getType());
        assertEquals(0, video.getViews());
    }

    @Test
    void testWatchVideo() {
        Video video = new Video("Best video", LocalDate.of(2022, 11, 11), 12,Type.INTERVIEW);

        video.watchVideo();

        assertEquals(1, video.getViews());
    }
}