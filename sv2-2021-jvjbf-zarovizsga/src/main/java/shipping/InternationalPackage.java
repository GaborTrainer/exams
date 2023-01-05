package shipping;

public class InternationalPackage implements Transportable {

    private static final int PRICE = 1200;

    private static final int PRICE_OF_KM = 10;

    private int weight;

    private boolean breakable;

    private String destinationCountry;

    private int distance;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        int distancePrice = distance * PRICE_OF_KM;
        if (isBreakable()) {
            return (PRICE * 2) + distancePrice;
        }
        return PRICE + distancePrice;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }
}
