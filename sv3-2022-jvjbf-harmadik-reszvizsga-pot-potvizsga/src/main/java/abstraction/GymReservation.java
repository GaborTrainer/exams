package abstraction;

import java.time.LocalDateTime;

public interface GymReservation {

    String getContactName();

    LocalDateTime getReservationTime();

    int calculatePriceToPay();
}
