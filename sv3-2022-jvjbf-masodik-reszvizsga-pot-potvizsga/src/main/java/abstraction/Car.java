package abstraction;

public class Car implements Rentable {

    private String id;

    private RentingData rentingData;

    private int distanceCanMake;

    public Car(String id, int distanceCanMake) {
        this.id = id;
        this.distanceCanMake = distanceCanMake;
    }

    public void tank(int fill) {
        distanceCanMake += fill;
    }

    @Override
    public void rent(User user, int km) {
        if (rentingData != null) {
            throw new IllegalStateException("The car is not available!");
        }
        if (distanceCanMake > km) {
            rentingData = new RentingData(user, km);
        } else {
            throw new IllegalArgumentException("Cannot make this distance: " + km);
        }
    }

    @Override
    public void closeRent() {
        if (rentingData == null) {
            throw new IllegalStateException("Vehicle is not rented!");
        }
        distanceCanMake -= rentingData.getActualKm();
        rentingData.addEarlierRentToUser(this);
        rentingData = null;
    }

    @Override
    public boolean isFree() {
        return rentingData == null;
    }

    @Override
    public String getId() {
        return id;
    }

    public RentingData getRentingData() {
        return rentingData;
    }

    public int getDistanceCanMake() {
        return distanceCanMake;
    }
}
