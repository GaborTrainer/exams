package teams;

import java.util.ArrayList;
import java.util.List;

public class League {

    private List<Team> teams;

    public League(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return  new ArrayList<>(teams);
    }

    public Team findTeamWithPlayer(String name){
//        Team result = null;
//        for(Team team : teams){
//            if(team.isPlayerWithNameInTeam(name)){
//                result = team;
//            }
//        }
//        return result;
        return teams.stream()
                .filter(team -> team.isPlayerWithNameInTeam(name))
                .findFirst()
                .get();
    }
}
