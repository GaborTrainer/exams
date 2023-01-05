package abstraction;

import java.util.HashSet;
import java.util.Set;

public class Gym {

    private Set<GymReservation> reservations = new HashSet<>();
    public boolean addReservation(GymReservation reservation) {
        return reservations.add(reservation);
    }

    public Set<GymReservation> getReservations() {
        return new HashSet<>(reservations);
    }
}
