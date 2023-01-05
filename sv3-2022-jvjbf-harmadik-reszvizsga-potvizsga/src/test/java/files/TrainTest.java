package files;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainTest {

    @Test
    void createTrain() {
        Train train = new Train("HJK19283", TrainType.IC, LocalTime.of(12, 30));

        assertEquals("HJK19283", train.getId());
        assertEquals(TrainType.IC, train.getTrainType());
        assertEquals(LocalTime.of(12,30), train.getDepartureTime());
    }
}