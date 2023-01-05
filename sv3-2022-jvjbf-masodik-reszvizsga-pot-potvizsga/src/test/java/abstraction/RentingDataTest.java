package abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentingDataTest {

    @Test
    void testCreateRentingData() {
        RentingData rentingData = new RentingData(new User("user1"), 54);

        assertEquals("user1", rentingData.getActualUser().getUserName());
        assertEquals(54, rentingData.getActualKm());
    }

    @Test
    void testAddEarlierRentToUser() {
        RentingData rentingData = new RentingData(new User("user1"), 54);
        Rentable rentable = new Bike("JHSJ789");

        rentingData.addEarlierRentToUser(rentable);

        assertEquals(1, rentingData.getActualUser().getEarlierRents().size());
    }
}