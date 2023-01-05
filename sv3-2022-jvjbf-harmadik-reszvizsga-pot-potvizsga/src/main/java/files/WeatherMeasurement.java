package files;

import java.time.LocalTime;

public class WeatherMeasurement {

    private LocalTime time;

    private int celsiusDegree;

    public WeatherMeasurement(LocalTime time, int celsiusDegree) {
        this.time = time;
        this.celsiusDegree = celsiusDegree;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getCelsiusDegree() {
        return celsiusDegree;
    }
}
