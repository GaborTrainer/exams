package railwaystation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RailwayStation {

    private List<Train> trainsAtStation = new ArrayList<>();

    public void addTrain(Train train) {
        if (trainsAtStation.size() < 10) {
            trainsAtStation.add(train);
        } else {
            throw new IllegalArgumentException("Too much trains!");
        }
    }

    public List<Train> getTrainsAtStation() {
        return new ArrayList<>(trainsAtStation);
    }

    public Train getLongestTrain() {
        return trainsAtStation.stream()
                .max(Comparator.comparingInt(Train::getTotalLength))
                .orElseThrow();
    }

    public int getHowManyTrainsHaveName() {
        return trainsAtStation.stream()
                .filter(t -> t.getName() != null)
                .toList().size();
    }

    public List<Train> getTrainsWithPassengersMoreThan(int number) {
        return trainsAtStation.stream()
                .filter(t->t.calculateTravellingPeople() > number)
                .toList();
    }
}
