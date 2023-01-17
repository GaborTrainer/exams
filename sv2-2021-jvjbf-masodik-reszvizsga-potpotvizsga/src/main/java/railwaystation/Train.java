package railwaystation;

public abstract class Train {

    public static final int LENGTH_OF_WAGON = 15;

    private String name;

    private int wagons;

    protected Train(int wagons) {
        this.wagons = wagons;
    }

    public String getName() {
        return name;
    }

    public int getWagons() {
        return wagons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalLength() {
        return wagons * LENGTH_OF_WAGON;
    }

    public abstract int calculateTravellingPeople();
}
