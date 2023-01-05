package abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCreateCar() {
        Rentable rentable = new Car("HJK-789", 432);

        assertEquals("HJK-789", rentable.getId());
        assertEquals(432, ((Car) rentable).getDistanceCanMake());
    }

    @Test
    void testRentCar() {
        User user = new User("user1");
        Car car = new Car("HJK-789", 432);

        car.rent(user, 321);

        assertEquals("user1", car.getRentingData().getActualUser().getUserName());
        assertEquals(321, car.getRentingData().getActualKm());
        assertEquals(432, car.getDistanceCanMake());
    }

    @Test
    void testCloseRent() {
        User user = new User("user1");
        Car car = new Car("HJK-789", 432);

        car.rent(user, 321);
        car.closeRent();

        assertEquals(111, car.getDistanceCanMake());
        assertEquals("HJK-789", user.getEarlierRents().get(0).getId());
        assertNull(car.getRentingData());
    }

    @Test
    void testIsFree() {
        User user = new User("user1");
        Car car = new Car("HJK-789", 432);

        assertTrue(car.isFree());

        car.rent(user, 12);

        assertFalse(car.isFree());
    }

    @Test
    void testTank() {
        Car car = new Car("HJK-789", 432);
        car.tank(5);

        assertEquals(437, car.getDistanceCanMake());
    }

    @Test
    void testRentIsNotAvailable() {
        User user = new User("user1");
        Car car = new Car("HJK-789", 432);

        car.rent(user, 321);

        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> car.rent(new User("user2"), 121));

        assertEquals("The car is not available!", ise.getMessage());
    }

    @Test
    void testRentCarCannotMakeDistance() {
        User user = new User("user1");
        Car car = new Car("HJK-789", 432);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> car.rent(user, 433));

        assertEquals("Cannot make this distance: 433", iae.getMessage());
    }

    @Test
    void testCannotCloseRent() {
        Car car = new Car("HJK-789", 432);

        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> car.closeRent());

        assertEquals("Vehicle is not rented!", ise.getMessage());
    }
}