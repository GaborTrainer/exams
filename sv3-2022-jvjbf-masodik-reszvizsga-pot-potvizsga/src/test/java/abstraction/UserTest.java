package abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testCreateUser() {
        User user = new User("user1");

        assertEquals("user1", user.getUserName());
        assertEquals(0, user.getEarlierRents().size());
    }

    @Test
    void testAddEarlierRent() {
        Rentable rentable = new Car("HGJ-987", 234);
        User user = new User("user1");
        user.addEarlierRent(rentable);

        assertEquals(1, user.getEarlierRents().size());
    }

    @Test
    void testCountFreeInEarlierRents() {
        User user = new User("user1");

        Car car = new Car("HJZ-152", 176);
        Car car2 = new Car("HJL-678", 232);
        Car car3 = new Car("HJK-879", 654);
        Bike bike = new Bike("JK987");

        car.rent(user, 100);
        car.closeRent();
        car3.rent(user, 50);
        car3.closeRent();
        bike.rent(user, 11);
        bike.closeRent();

        User user2 = new User("user2");
        bike.rent(user2, 13);

        int count = user.countFreeInEarlierRent();

        assertEquals(2, count);
    }
}