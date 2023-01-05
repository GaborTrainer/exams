package files;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherServiceTest {

    WeatherService weatherService = new WeatherService();

    @Test
    void testReadFromFile() {
        weatherService.readFromFile(Path.of("src/test/resources/input.txt"));

        assertEquals(4, weatherService.getMeasurements().keySet().size());
    }

    @Test
    void testMeasurementDatesAreOrdered() {
        weatherService.readFromFile(Path.of("src/test/resources/input.txt"));

        assertEquals(Set.of(LocalDate.of(2022, 11, 14),
                LocalDate.of(2022, 11, 15),
                LocalDate.of(2022, 11, 17),
                LocalDate.of(2022, 11, 19)), weatherService.getMeasurements().keySet());
    }

//    @Test
//    void testMeasurementTimesAreOrdered() {
//        weatherService.readFromFile(Path.of("src/test/resources/input.txt"));
//        List<WeatherMeasurement> measurements = weatherService.getMeasurements().get(LocalDate.of(2022, 11, 17));
//
//        assertEquals(List.of(LocalTime.of(15, 30),
//                LocalTime.of(17, 30),
//                LocalTime.of(18, 30)), measurements.stream().map(WeatherMeasurement::getTime).toList());
//    }

    @Test
    void testCannotReadFile() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> weatherService.readFromFile(Path.of("src/test/resources/test.txt")));
    }

    @Test
    void testFindDateWithMostMeasurements() {
        weatherService.readFromFile(Path.of("src/test/resources/input.txt"));
        LocalDate date = weatherService.findDateWithMostMeasurements();

        assertEquals(LocalDate.of(2022, 11, 19), date);
    }

    @Test
    void testFindMeasurementByDateAndTime() {
        weatherService.readFromFile(Path.of("src/test/resources/input.txt"));
        int temp = weatherService.findTemperatureByDateAndTime(LocalDate.of(2022, 11, 14), LocalTime.of(17, 20));

        assertEquals(19, temp);
    }

    @Test
    void testFindMeasurementByDateAndTimeNotValidDate() {
        weatherService.readFromFile(Path.of("src/test/resources/input.txt"));

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> weatherService.findTemperatureByDateAndTime(LocalDate.of(2022, 11, 13), LocalTime.of(17, 20)));
        assertEquals("Date not in data structure: 2022-11-13", iae.getMessage());
    }

    @Test
    void testFindMeasurementByDateAndTimeNotValidTime() {
        weatherService.readFromFile(Path.of("src/test/resources/input.txt"));

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> weatherService.findTemperatureByDateAndTime(LocalDate.of(2022, 11, 14), LocalTime.of(16, 20)));
        assertEquals("No time on that day: 16:20", iae.getMessage());
    }

    @Test
    void testFindMeasurementsByDate() {
        weatherService.readFromFile(Path.of("src/test/resources/input.txt"));
        List<LocalTime> result = weatherService.findMeasurementsByDate(LocalDate.of(2022, 11, 17));
        assertEquals(List.of(
                LocalTime.of(15, 30),
                LocalTime.of(17, 30),
                LocalTime.of(18, 30)
        ), result);
    }

    @Test
    void testFindMeasurementsByDateNoDate() {
        weatherService.readFromFile(Path.of("src/test/resources/input.txt"));

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> weatherService.findMeasurementsByDate(LocalDate.of(2022, 11, 13)));
        assertEquals("Date not in data structure: 2022-11-13", iae.getMessage());
    }
}