package abstraction;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;

    private List <Rentable> earlierRents = new ArrayList<>();

    void addEarlierRent(Rentable rentable) {
        earlierRents.add(rentable);
    }

    public int countFreeInEarlierRent() {
        int count = 0;
        for (Rentable rentable : earlierRents) {
            if (rentable.isFree()) {
                count++;
            }
        }
        return count;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public List<Rentable> getEarlierRents() {
        return earlierRents;
    }
}
