package railwaystation;

public class PassengerTrain extends Train {

    private static final int NUMBER_OF_PEOPLE_PER_WAGON = 70;

    public boolean hasDiningCar;

    public PassengerTrain(int wagons) {
        super(wagons);
        hasDiningCar = false;
    }

    public PassengerTrain(String name, int wagons) {
        super(wagons);
        setName(name);
        hasDiningCar = true;
    }

    @Override
    public int calculateTravellingPeople() {
        if (hasDiningCar) {
            return (getWagons() - 1) * NUMBER_OF_PEOPLE_PER_WAGON;
        }
        return getWagons() * NUMBER_OF_PEOPLE_PER_WAGON;
    }

    public boolean hasDiningCar() {
        return hasDiningCar;
    }
}
