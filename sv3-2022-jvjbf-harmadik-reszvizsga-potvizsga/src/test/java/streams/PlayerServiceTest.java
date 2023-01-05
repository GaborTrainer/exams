package streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerServiceTest {

    PlayerService playerService = new PlayerService();

    @BeforeEach
    void init() {
        playerService.addPlayer(new Player("John Doe", "Arsenal", LocalDate.of(1993, 10, 11), 12));
        playerService.addPlayer(new Player("Jack Doe", "Arsenal", LocalDate.of(1992, 11, 10), 13));
        playerService.addPlayer(new Player("Jim Doe", "Chelsea", LocalDate.of(1995, 9, 13), 5));
        playerService.addPlayer(new Player("Joe Doe", "Liverpool", LocalDate.of(1991, 5, 3), 7));
    }

    @Test
    void testFindTeams() {
        Set<String> teams = playerService.findTeams();

        assertEquals(Set.of("Arsenal", "Liverpool", "Chelsea"), teams);
    }

    @Test
    void testFindPlayerWithMaxGoals() {
        Optional<Player> result = playerService.findPlayerWithMaxGoals();

        assertEquals(13, result.get().getNumberOfGoals());
        assertEquals("Arsenal", result.get().getTeam());
    }

    @Test
    void testFindPlayersBirthBefore() {
        List<Player> result = playerService.findPlayersBirthBefore(LocalDate.of(1995, 9, 11));

        assertEquals(3, result.size());
        assertEquals(List.of("John Doe", "Jack Doe", "Joe Doe"), result.stream().map(Player::getName).toList());
    }

    @Test
    void testFindPlayersBirthAfterScoredMoreThan() {
        List<Player> result = playerService.findPlayersBirthAfterScoredMoreThan(LocalDate.of(1991, 6, 7), 5);

        assertEquals(2, result.size());
        assertEquals(List.of("Jack Doe", "John Doe"), result.stream().map(Player::getName).toList());
    }
}