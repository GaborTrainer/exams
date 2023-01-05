package files;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrainServiceTest {

    TrainService trainService = new TrainService();

    @Test
    void testReadFromFile() {

        trainService.readFromFile(Path.of("src/test/resources/input.txt"));

        assertEquals(4, trainService.getSchedule().keySet().size());
        assertEquals(Set.of("Birmingham", "Liverpool", "Manchester", "Norwich"), trainService.getSchedule().keySet());
        assertEquals(4, trainService.getSchedule().get("Liverpool").size());
    }

    @Test
    void testGetSchedule() {
        trainService.readFromFile(Path.of("src/test/resources/input.txt"));
        trainService.getSchedule().put("Test", new ArrayList<>());

        assertEquals(4, trainService.getSchedule().keySet().size());
    }

    @Test
    void testFindCityWithMostTrains() {
        trainService.readFromFile(Path.of("src/test/resources/input.txt"));

        String city = trainService.findCityWithMostTrains();

        assertEquals("Liverpool", city);
    }

    @Test
    void testFindCityWithMostTrainsEmptyDataStructure() {
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> trainService.findCityWithMostTrains());
        assertEquals("Data structure is empty!", ise.getMessage());
    }

    @Test
    void testFindDestinationByTrainId() {
        trainService.readFromFile(Path.of("src/test/resources/input.txt"));

        String city = trainService.findDestinationByTrainId("BH1987");

        assertEquals("Birmingham", city);
    }

    @Test
    void testFIndDestinationByTrainIdWrongId() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> trainService.findDestinationByTrainId("JKLPO6"));

        assertEquals("Cannot find train with id: JKLPO6", iae.getMessage());
    }

    @Test
    void testFindDeparturesToCity() {
        trainService.readFromFile(Path.of("src/test/resources/input.txt"));

        List<LocalTime> result = trainService.findDeparturesToCity("Birmingham");

        assertEquals(List.of(LocalTime.of(16, 14), LocalTime.of(16, 20)), result);
    }

    @Test
    void testFindDeparturesToCityWrongCity(){
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                ()->trainService.findDeparturesToCity("London"));

        assertEquals("City is not in schedule: London",iae.getMessage());
    }
}