package teams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Team {

    private static final int MAX_PLAYERS = 18;
    private String teamName;
    private List<Player> players = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public boolean addPlayer(Player player) {
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
            return true;
        }
        return false;
    }

    public int countBirthBefore(LocalDate date) {
//        int count = 0;
//        for (Player player : players) {
//            if (player.getDateOfBirth().isBefore(date)) {
//                count++;
//            }
//        }
//        return count;
        return (int) players.stream()
                .filter(player -> player.getDateOfBirth().isBefore(date))
                .count();
    }

    public boolean isPlayerWithNameInTeam(String name) {
//        for(Player player : players){
//            if(player.getName().equals(name)){
//                return true;
//            }
//        }
//        return false;
        return players.stream()
                .map(Player::getName)
                .anyMatch(s -> s.equals(name));
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
