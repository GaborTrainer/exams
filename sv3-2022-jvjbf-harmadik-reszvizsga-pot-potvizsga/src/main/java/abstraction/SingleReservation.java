package abstraction;

import java.time.LocalDateTime;

public class SingleReservation implements GymReservation {

    private static int PRICE = 4500;

    private String contactName;

    private LocalDateTime reservationTime;

    private boolean hasSeasonTicket;

    public SingleReservation(String contactName, LocalDateTime reservationTime) {
        this.contactName = contactName;
        this.reservationTime = reservationTime;
    }

    public void buySeasonTicket() {
        hasSeasonTicket = true;
    }

    @Override
    public String getContactName() {
        return contactName;
    }

    @Override
    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    @Override
    public int calculatePriceToPay() {
        return hasSeasonTicket ? PRICE / 2 : PRICE;
    }
}
