package vehiclerental;

import java.time.LocalTime;

public interface Rentable {

    int calculateSumPrice(long minutes);

    LocalTime getRentingTime();

    void rent(LocalTime time);

    void closeRent();
}
