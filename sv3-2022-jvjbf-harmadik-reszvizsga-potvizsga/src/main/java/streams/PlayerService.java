package streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PlayerService {

    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }


    public Set<String> findTeams() {
        return players.stream()
                .map(Player::getTeam)
                .collect(Collectors.toSet());
    }

    public Optional<Player> findPlayerWithMaxGoals() {
        return players.stream()
                .max(Comparator.comparingInt(Player::getNumberOfGoals));
    }


    public List<Player> findPlayersBirthBefore(LocalDate date) {
        return players.stream()
                .filter(player -> player.getDateOfBirth().isBefore(date))
                .toList();
    }

    public List<Player> findPlayersBirthAfterScoredMoreThan(LocalDate date, int numberOfGoals) {
        return players.stream()
                .filter(player -> player.getDateOfBirth().isAfter(date) && player.getNumberOfGoals() > numberOfGoals)
                .sorted(Comparator.comparing(Player::getName))
                .toList();
    }
}
