package vehiclerental;

import java.time.LocalTime;
import java.util.*;

public class RentService {

    private static final int MAX_RENT_MINUTE = 180;

    private Set<Rentable> rentable = new HashSet<>();

    private Set<User> users = new HashSet<>();

    private Map<Rentable, User> actualRenting = new TreeMap<>();

    public Set<Rentable> getRentable() {
        return rentable;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Map<Rentable, User> getActualRenting() {
        return actualRenting;
    }

    public void registerUser(User user) {
        if (users.stream().anyMatch(o->o.getUserName().equals(user.getUserName()))) {
            throw new UserNameIsAlreadyTakenException("Username is taken!");
        }
        users.add(user);
    }

    public void addRentable(Rentable r) {
        rentable.add(r);
    }

    public void rent(User user, Rentable r, LocalTime time) {
        if (user.getBalance() >= r.calculateSumPrice(MAX_RENT_MINUTE) && r.getRentingTime() == null) {
            r.rent(time);
            actualRenting.put(r, user);
        } else {
            throw new IllegalStateException();
        }
    }

    public void closeRent(Rentable r, int minutes) {
        if (actualRenting.containsKey(r)) {
            actualRenting.get(r).minusBalance(r.calculateSumPrice(minutes));
            actualRenting.remove(r);
            r.closeRent();
        } else {
            throw new IllegalStateException("Rentable is not taken!");
        }
    }
}

