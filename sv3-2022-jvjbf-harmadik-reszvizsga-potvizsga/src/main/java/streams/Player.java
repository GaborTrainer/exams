package streams;

import java.time.LocalDate;

public class Player {

    private String name;

    private String team;

    private LocalDate dateOfBirth;

    private int numberOfGoals;

    public Player(String name, String team, LocalDate dateOfBirth, int numberOfGoals) {
        this.name = name;
        this.team = team;
        this.dateOfBirth = dateOfBirth;
        this.numberOfGoals = numberOfGoals;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfGoals() {
        return numberOfGoals;
    }
}
