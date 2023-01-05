package abstraction;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GymTest {

    Gym gym = new Gym();

    @Test
    void testAddReservation() {
        gym.addReservation(new SingleReservation("John", LocalDateTime.of(2022, 11, 11, 11, 10)));
        gym.addReservation(new TeamReservation("John", List.of("Jack", "Jill"), LocalDateTime.of(2022, 11, 15, 17, 30)));

        assertEquals(2, gym.getReservations().size());
    }

    @Test
    void testAddReservationTwoSingleInSameTime() {
        gym.addReservation(new SingleReservation("Jack", LocalDateTime.of(2022, 11, 11, 11, 10)));
        boolean result = gym.addReservation(new SingleReservation("John", LocalDateTime.of(2022, 11, 11, 11, 10)));

        assertEquals(2, gym.getReservations().size());
        assertTrue(result);
    }

    @Test
    void testAddReservationTwoTeamSameTime() {
        gym.addReservation(new TeamReservation("John", List.of("Jack", "Jill"), LocalDateTime.of(2022, 11, 15, 17, 30)));
        boolean result = gym.addReservation(new TeamReservation("Jack", List.of("Jack", "Jill"), LocalDateTime.of(2022, 11, 15, 17, 30)));

        assertEquals(1, gym.getReservations().size());
        assertFalse(result);
    }
}