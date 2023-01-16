package datahandling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {

    @Test
    void testConstructorWithId(){
        Rating rating = new Rating(42L,"Ede",9,1,10);
        assertEquals(42, rating.getId());
    }

    @Test
    void testConstructorWithoutId(){
        Rating rating = new Rating("Pallas_Athéné",9,1,10);
        assertEquals(0, rating.getId());
    }

    @Test
    void testGetters(){
        Rating rating = new Rating(0L,"Ede",9,1,10);
        assertEquals(0L, rating.getId());
        assertEquals("Ede", rating.getNickname());
        assertEquals(9, rating.getMonth());
        assertEquals(1, rating.getTaskNr());
        assertEquals(10, rating.getRatingValue());
    }
}