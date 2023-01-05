package teams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    Team team = new Team("Arsenal");

    @BeforeEach
    void init(){
        int month = 1;
        for(int i=0;i<6;i++){
            team.addPlayer((new Player("John Doe"+i, LocalDate.of(1994, month++, 12), i, Position.STRIKER)));
        }
    }

    @Test
    void createTeamTest(){
        Team team = new Team("Chelsea");

        assertEquals("Chelsea",team.getTeamName());
        assertEquals(0, team.getPlayers().size());
    }


    @Test
    void testAddPlayer(){
        Team team = new Team("Chelsea");

        team.addPlayer(new Player("John Doe", LocalDate.of(1994, 11, 12), 7, Position.STRIKER));

        assertEquals(1, team.getPlayers().size());
    }

    @Test
    void testAddPlayerReturnValue(){
        Team team = new Team("Chelsea");

        assertTrue(team.addPlayer(new Player("John Doe", LocalDate.of(1994, 11, 12), 7, Position.STRIKER)));
    }

    @Test
    void testCannotAddPlayer(){
        Team team = new Team("Chelsea");
        for(int i=0;i<18;i++){
            team.addPlayer((new Player("John Doe"+i, LocalDate.of(1994, 11, 12), 7, Position.STRIKER)));
        }

        team.addPlayer(new Player("Jack Doe", LocalDate.of(1993, 11, 12), 7, Position.GOALKEEPER));

        assertEquals(18, team.getPlayers().size());
    }

    @Test
    void testCannotAddPlayerReturnValue(){
        Team team = new Team("Chelsea");
        for(int i=0;i<18;i++){
            team.addPlayer((new Player("John Doe"+i, LocalDate.of(1994, 11, 12), 7, Position.STRIKER)));
        }

        assertFalse(team.addPlayer(new Player("Jack Doe", LocalDate.of(1993, 11, 12), 7, Position.GOALKEEPER)));

    }

    @Test
    void testCountBirthBefore(){
        assertEquals(3, team.countBirthBefore(LocalDate.of(1994,4,9)));
        assertEquals(2, team.countBirthBefore(LocalDate.of(1994,3,11)));
    }

    @Test
    void testIsPlayerWithName(){
        assertTrue(team.isPlayerWithNameInTeam("John Doe3"));
    }

    @Test
    void testIsNotPlayerWithName(){
        assertFalse(team.isPlayerWithNameInTeam("Jack"));
    }

}