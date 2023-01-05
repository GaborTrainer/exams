package abstraction;

public interface Rentable {

    void rent(User user, int km);

    void closeRent();

    boolean isFree();

    String getId();
}
