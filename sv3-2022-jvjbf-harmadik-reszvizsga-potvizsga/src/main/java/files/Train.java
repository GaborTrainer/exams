package files;

import java.time.LocalTime;

public class Train {

    private String id;

    private TrainType trainType;

    private LocalTime departureTime;

    public Train(String id, TrainType trainType, LocalTime departureTime) {
        this.id = id;
        this.trainType = trainType;
        this.departureTime = departureTime;
    }

    public String getId() {
        return id;
    }

    public TrainType getTrainType() {
        return trainType;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }
}
