package abstraction;

public class Bike implements Rentable {

    private String id;

    private RentingData rentingData;

    private int sumKm;

    public Bike(String id) {
        this.id = id;
    }

    @Override
    public void rent(User user, int km) {
        if (rentingData != null) {
            throw new IllegalStateException("The bike is not available!");
        }
        rentingData = new RentingData(user, km);
    }

    @Override
    public void closeRent() {
        if (rentingData == null) {
            throw new IllegalStateException("Vehicle is not rented!");
        }
        sumKm += rentingData.getActualKm();
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

    public int getSumKm() {
        return sumKm;
    }
}
