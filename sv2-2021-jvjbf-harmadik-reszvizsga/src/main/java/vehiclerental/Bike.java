package vehiclerental;

import java.time.LocalTime;

public class Bike implements Rentable{

    private String id;

    private LocalTime rentingTime;

    private static final int FT_PER_MINUTE = 15;

    public Bike(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) minutes * FT_PER_MINUTE;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        rentingTime = time;
    }

    @Override
    public void closeRent() {
        rentingTime = null;
    }
}
