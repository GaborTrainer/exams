package files;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ChampionsLeagueServiceTest {

    ChampionsLeagueService championsLeagueService = new ChampionsLeagueService();

    @Test
    void testReadFromFile() {
        championsLeagueService.readFromFile(Path.of("src/test/resources/input.txt"));

        assertEquals(11, championsLeagueService.getSchedule().keySet().size());
    }

    @Test
    void testReadFromFIleCorrectOrder() {
        championsLeagueService.readFromFile(Path.of("src/test/resources/input.txt"));

        assertEquals("[Barcelona, Bayern München, Chelsea, Dinamo Zagreb, Inter, Milan, Plzen, RB Leipzig, RB Salzburg, Real Madrid, Sahtar]",
                championsLeagueService.getSchedule().keySet().toString());
    }

    @Test
    void testCollectPlayDays() {
        championsLeagueService.readFromFile(Path.of("src/test/resources/input.txt"));

        Set<LocalDate> result = championsLeagueService.collectPlayDays();

        assertEquals(9, result.size());
        assertTrue(result.contains(LocalDate.of(2022, 10, 11)));
    }

    @Test
    void testFindTeamsByDay() {
        championsLeagueService.readFromFile(Path.of("src/test/resources/input.txt"));
        Set<String> result = championsLeagueService.findTeamsByDay(LocalDate.of(2022, 10, 4));

        assertEquals(Set.of("Bayern München", "Plzen", "Barcelona", "Inter"), result);

    }

    @Test
    void testFindTeamWithMostPlayed() {
        championsLeagueService.readFromFile(Path.of("src/test/resources/input.txt"));

        assertEquals("Bayern München", championsLeagueService.findTeamWithMostPlayedMatches());
    }
}