package abstractions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvertisementTest {

    @Test
    void createAdvertisementTest() {
        Content advertisement = new Advertisement("Best Laptop!!");

        assertEquals("Best Laptop!!", advertisement.getTitle());
        assertEquals(1, advertisement.getImportance());
    }
}