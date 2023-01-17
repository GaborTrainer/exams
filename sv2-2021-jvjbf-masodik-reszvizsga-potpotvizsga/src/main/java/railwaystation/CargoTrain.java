package railwaystation;

import java.util.ArrayList;
import java.util.List;

public class CargoTrain extends Train {

    private List<Train> trainsAtStation = new ArrayList<>();

    public CargoTrain(int wagons) {
        super(wagons);
    }

    @Override
    public int calculateTravellingPeople() {
        return Math.max(getWagons() / 10, 1);
    }

    public List<Train> getTrainsAtStation() {
        return new ArrayList<>(trainsAtStation);
    }
}
