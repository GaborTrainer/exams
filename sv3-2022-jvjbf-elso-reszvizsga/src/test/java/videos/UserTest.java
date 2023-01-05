package videos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void init(){
        user = new User("JohnnyDoe");
        user.uploadVideo(new Video("Best video", LocalDate.of(2022, 11, 11), 12,Type.INTERVIEW));
        user.uploadVideo(new Video("Better video", LocalDate.of(2022, 11, 11), 12,Type.DOCUMENTARY));
        user.uploadVideo(new Video("Worst video", LocalDate.of(2022, 11, 11), 12,Type.INTERVIEW));

    }

    @Test
    void createUser() {
        User user = new User("JohnnyDoe");

        assertEquals("JohnnyDoe", user.getUserName());
        assertEquals(0, user.getVideos().size());
    }

    @Test
    void testUploadVideo(){
        User user = new User("JohnnyDoe");

        user.uploadVideo(new Video("Best video", LocalDate.of(2022, 11, 11), 12,Type.DOCUMENTARY));

        assertEquals(1, user.getVideos().size());
        assertEquals("Best video",user.getVideos().get(0).getTitle());
    }


    @Test
    void testCountVideosByType() {
        assertEquals(2, user.countVideosByType(Type.INTERVIEW));
        assertEquals(1, user.countVideosByType(Type.DOCUMENTARY));
        assertEquals(0,user.countVideosByType(Type.VLOG));
    }

    @Test
    void testSumOfViews(){
        user.getVideos().get(0).watchVideo();
        user.getVideos().get(0).watchVideo();
        user.getVideos().get(0).watchVideo();
        user.getVideos().get(2).watchVideo();
        user.getVideos().get(2).watchVideo();

        assertEquals(5, user.sumOfViews());
    }

    @Test
    void testSumOfViewsWithNoViews(){
        assertEquals(0, user.sumOfViews());
    }
}