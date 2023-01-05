package teams;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    void testCreatePlayer() {
        Player player = new Player("John Doe", LocalDate.of(1994, 11, 12), 7, Position.STRIKER);

        assertEquals("John Doe", player.getName());
        assertEquals(LocalDate.of(1994, 11, 12), player.getDateOfBirth());
        assertEquals(7, player.getNumber());
        assertEquals(Position.STRIKER, player.getPosition());
    }

}