package abstraction;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleReservationTest {

    @Test
    void testCreateSingleReservation() {
        GymReservation reservation = new SingleReservation("John", LocalDateTime.of(2022, 11, 11, 11, 10));

        assertEquals("John", reservation.getContactName());
        assertEquals(LocalDateTime.of(2022, 11, 11, 11, 10), reservation.getReservationTime());
    }

    @Test
    void testCalculatePriceToPayNoSeasonTicket() {
        GymReservation reservation = new SingleReservation("John", LocalDateTime.of(2022, 11, 11, 11, 10));

        assertEquals(4500, reservation.calculatePriceToPay());
    }

    @Test
    void testCalculatePriceToPayWithSeasonTicket() {
        GymReservation reservation = new SingleReservation("John", LocalDateTime.of(2022, 11, 11, 11, 10));
        ((SingleReservation) reservation).buySeasonTicket();

        assertEquals(2250, reservation.calculatePriceToPay());
    }
}