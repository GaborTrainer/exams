package shipping;

public class NationalPackage implements Transportable {

    private static final int PRICE = 1000;

    private int weight;

    private boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
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
        if (isBreakable()) {
            return PRICE * 2;
        }
        return PRICE;
    }

    @Override
    public String getDestinationCountry() {
        return Transportable.super.getDestinationCountry();
    }
}
