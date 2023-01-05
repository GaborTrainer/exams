package teams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {

    League league;

    @BeforeEach
    void init(){
        Team chelsea = new Team("Chelsea");
        Team arsenal = new Team("Arsenal");

        for(int i=0;i<11;i++){
            chelsea.addPlayer(new Player("John Doe"+i, LocalDate.of(1994, 11, 12), 7, Position.MIDFIELDER));
        }

        for(int i=0;i<11;i++){
            arsenal.addPlayer(new Player("Jack Doe"+i, LocalDate.of(1994, 11, 12), 7, Position.MIDFIELDER));
        }

        league = new League(Arrays.asList(chelsea,arsenal));
    }


    @Test
    void testFindTeamWithPlayer(){
        assertEquals("Arsenal",league.findTeamWithPlayer("Jack Doe9").getTeamName());
    }

    @Test
    void testFindTeamWithPlayerNotFound(){
        assertNull(league.findTeamWithPlayer("Jonathan Doe"));
    }

}