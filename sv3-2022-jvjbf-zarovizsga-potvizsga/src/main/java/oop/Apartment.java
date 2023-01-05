package oop;

public class Apartment {

    private static final int BASE_PRICE = 40_000;

    private int roomNumber;

    private boolean free = true;

    private FoodServiceType foodServiceType;

    private int peopleCanFit;

    public Apartment(int roomNumber, int peopleCanFit) {
        this.roomNumber = roomNumber;
        this.peopleCanFit = peopleCanFit;
        this.foodServiceType = FoodServiceType.BREAKFAST;
    }

    public void rent() {
        if (free) {
            free = false;
        } else {
            throw new CantRentException("Not free!");
        }
    }

    public void upgradeService(FoodServiceType serviceType) {
        if (serviceType.getExtraPrice() <= foodServiceType.getExtraPrice()) {
            throw new IllegalArgumentException("Cannot upgrade lower or same!");
        }
        foodServiceType = serviceType;
    }

    public int getPrice() {
        return BASE_PRICE + foodServiceType.getExtraPrice();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isFree() {
        return free;
    }

    public FoodServiceType getFoodServiceType() {
        return foodServiceType;
    }

    public int getPeopleCanFit() {
        return peopleCanFit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment apartment)) return false;

        return roomNumber == apartment.roomNumber;
    }

    @Override
    public int hashCode() {
        return roomNumber;
    }
}
