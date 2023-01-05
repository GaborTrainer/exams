package abstraction;

public class RentingData {

    private User actualUser;

    private int actualKm;

    public RentingData(User actualUser, int actualKm) {
        this.actualUser = actualUser;
        this.actualKm = actualKm;
    }

    void addEarlierRentToUser(Rentable rentable) {
        actualUser.addEarlierRent(rentable);
    }

    public User getActualUser() {
        return actualUser;
    }

    public int getActualKm() {
        return actualKm;
    }
}
