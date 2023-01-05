package abstraction;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamReservationTest {

    @Test
    void testCreateTeamReservation() {
        GymReservation reservation = new TeamReservation("John", List.of("Jack", "Jill"), LocalDateTime.of(2022, 11, 15, 17, 30));

        assertEquals("John", reservation.getContactName());
        assertEquals(LocalDateTime.of(2022, 11, 15, 17, 30), reservation.getReservationTime());
    }

    @Test
    void testCalculatePrice() {
        GymReservation reservation = new TeamReservation("John", List.of("Jack", "Jill"), LocalDateTime.of(2022, 11, 15, 17, 30));

        assertEquals(3000, reservation.calculatePriceToPay());
    }
}