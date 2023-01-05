package abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BikeTest {

    @Test
    void testCreateBike() {
        Rentable rentable = new Bike("JHGH678");

        assertEquals("JHGH678", rentable.getId());
        assertNull(((Bike) rentable).getRentingData());
    }

    @Test
    void testRent() {
        User user = new User("user1");
        Bike bike = new Bike("HK89");

        bike.rent(user, 12);

        assertEquals("user1", bike.getRentingData().getActualUser().getUserName());
        assertEquals(12, bike.getRentingData().getActualKm());
        assertEquals(0, bike.getSumKm());
    }

    @Test
    void testCloseRent() {
        User user = new User("user1");
        Bike bike = new Bike("HK89");

        bike.rent(user, 12);
        bike.closeRent();

        assertNull(bike.getRentingData());
        assertEquals(12, bike.getSumKm());
        assertEquals("HK89", user.getEarlierRents().get(0).getId());
    }

    @Test
    void testIsFree() {
        User user = new User("user1");
        Bike bike = new Bike("HK89");

        assertTrue(bike.isFree());

        bike.rent(user, 12);

        assertFalse(bike.isFree());
    }

    @Test
    void testRentNotAvailable() {
        User user = new User("user1");
        Bike bike = new Bike("HK89");

        bike.rent(user, 12);

        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> bike.rent(new User("user2"), 12));

        assertEquals("The bike is not available!", ise.getMessage());
    }

    @Test
    void testCannotCloseRent() {
        Bike bike = new Bike("HK89");

        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> bike.closeRent());

        assertEquals("Vehicle is not rented!", ise.getMessage());
    }
}