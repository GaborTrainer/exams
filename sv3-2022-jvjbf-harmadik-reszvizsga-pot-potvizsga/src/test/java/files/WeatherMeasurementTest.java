package files;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class WeatherMeasurementTest {

    @Test
    void createWeatherMeasurementTest() {
        WeatherMeasurement weatherMeasurement = new WeatherMeasurement(LocalTime.of(12, 31), 12);

        assertEquals(LocalTime.of(12, 31), weatherMeasurement.getTime());
        assertEquals(12, weatherMeasurement.getCelsiusDegree());
    }
}