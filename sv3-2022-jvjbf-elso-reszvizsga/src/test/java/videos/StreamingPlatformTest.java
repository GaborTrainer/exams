package videos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StreamingPlatformTest {

    StreamingPlatform streamingPlatform;

    @BeforeEach
    void init(){
        streamingPlatform = new StreamingPlatform();

        User johnny = new User("Johnny");
        User jackie = new User("Jackie");
        User jane = new User("Jane");

        streamingPlatform.addUser(johnny);
        streamingPlatform.addUser(jackie);
        streamingPlatform.addUser(jane);

        johnny.uploadVideo(new Video("Best video", LocalDate.of(2022,10,11),13,Type.DOCUMENTARY));
        johnny.uploadVideo(new Video("Better video", LocalDate.of(2022,10,12),12,Type.DOCUMENTARY));
        johnny.uploadVideo(new Video("Best video", LocalDate.of(2022,10,9),11,Type.DOCUMENTARY));


        jane.uploadVideo(new Video("Cool video",LocalDate.of(2022,11,12),11,Type.INTERVIEW));
        jane.uploadVideo(new Video("Coolest video",LocalDate.of(2022,9,12),10,Type.VLOG));


        johnny.getVideos().get(0).watchVideo();
        johnny.getVideos().get(1).watchVideo();
        johnny.getVideos().get(2).watchVideo();
        johnny.getVideos().get(2).watchVideo();

        jane.getVideos().get(0).watchVideo();
        jane.getVideos().get(0).watchVideo();
        jane.getVideos().get(0).watchVideo();
        jane.getVideos().get(1).watchVideo();
        jane.getVideos().get(0).watchVideo();


    }



    @Test
    void createStreamingPlatform(){
        StreamingPlatform streamingPlatform = new StreamingPlatform();

        assertEquals(0,streamingPlatform.getUsers().size());
    }

    @Test
    void testAddUSer(){
        StreamingPlatform streamingPlatform = new StreamingPlatform();

        streamingPlatform.addUser(new User("Johnny"));

        assertEquals(1, streamingPlatform.getUsers().size());
        assertEquals("Johnny", streamingPlatform.getUsers().get(0).getUserName());
    }

    @Test
    void testFindMaxViews(){
        assertEquals(5, streamingPlatform.findMaxViews());
    }

    @Test
    void testFindMaxViewsEmptyPlatform(){
        StreamingPlatform streamingPlatform = new StreamingPlatform();

        assertEquals(0, streamingPlatform.findMaxViews());
    }
}