package movietheatres;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {

    @Test
    void createMovie(){
        Movie movie = new Movie("Star Wars", LocalTime.of(12,30));

        assertEquals("Star Wars",movie.getTitle());
        assertEquals(LocalTime.of(12,30),movie.getStartTime());
    }

    @Test
    void testEqualsAndHashCode(){
        Movie movie = new Movie("Star Wars", LocalTime.of(12,30));
        Movie other = new Movie("Star Wars", LocalTime.of(13,30));

        assertEquals(movie, other);
        assertEquals(movie.hashCode(),other.hashCode());
    }
}