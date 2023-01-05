package teams;

import java.time.LocalDate;

public class Player {

    private String name;
    private LocalDate dateOfBirth;
    private int number;
    private Position position;

    public Player(String name, LocalDate dateOfBirth, int number, Position position) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.number = number;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumber() {
        return number;
    }

    public Position getPosition() {
        return position;
    }
}
