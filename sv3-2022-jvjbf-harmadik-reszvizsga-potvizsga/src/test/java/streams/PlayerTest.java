package streams;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void createPlayer() {
        Player player = new Player("John Doe", "Arsenal", LocalDate.of(1993, 10, 11), 12);

        assertEquals("John Doe", player.getName());
        assertEquals("Arsenal", player.getTeam());
        assertEquals(LocalDate.of(1993, 10, 11), player.getDateOfBirth());
        assertEquals(12, player.getNumberOfGoals());
    }
}