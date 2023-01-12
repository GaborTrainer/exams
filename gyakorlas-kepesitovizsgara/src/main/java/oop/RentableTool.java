package oop;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class RentableTool {

    private String id;

    private String name;

    private double priceMultiplier;

    private LocalDateTime rentFrom;

    private LocalDateTime rentTo;

    private int totalIncome;

    protected RentableTool(String id, String name, double priceMultiplier) {
        this.id = id;
        this.name = name;
        this.priceMultiplier = priceMultiplier;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public LocalDateTime getRentFrom() {
        return rentFrom;
    }

    public LocalDateTime getRentTo() {
        return rentTo;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void rent(LocalDateTime rentFrom, LocalDateTime rentTo) {
        isRented();
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
    }

    public void rent(LocalDateTime rentTo) {
        isRented();
        this.rentFrom = LocalDateTime.now();
        this.rentTo = rentTo;
    }

    private void isRented() {
        if (rentFrom != null) {
            throw new AlreadyRentedException("Already rented!");
        }
    }

    public int calculateRentalFee() {
        if (rentFrom == null || LocalDateTime.now().isBefore(rentFrom)) {
            return 0;
        }

        Duration duration = Duration.between(rentFrom, LocalDateTime.now());
        int hours = (int) (duration.getSeconds() / 3600); //3600 = 60 sec * 60min

        if (duration.getSeconds() > hours * 3600L) {
            hours++;
        }

        if (hours < 4) {
            return (int) (hours * Settings.BASIC_RENTAL_FEE * priceMultiplier);
        }
        if (hours < 25) {
            return (int) ((3 * Settings.BASIC_RENTAL_FEE * priceMultiplier) +
                    (hours - 3) * Settings.BASIC_RENTAL_FEE * priceMultiplier * 0.8);
        }
        return (int) ((3 * Settings.BASIC_RENTAL_FEE * priceMultiplier) +
                21 * Settings.BASIC_RENTAL_FEE * priceMultiplier * 0.8 +
                (hours - 24) * Settings.BASIC_RENTAL_FEE * priceMultiplier * 0.5);
    }

    public void giveBack() {
        if (rentFrom != null) {
            totalIncome += calculateRentalFee();
            rentFrom = null;
            rentTo = null;
        }
    }
}
