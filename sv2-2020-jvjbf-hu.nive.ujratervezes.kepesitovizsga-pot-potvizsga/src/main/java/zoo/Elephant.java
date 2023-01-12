package zoo;

import java.util.Objects;

public class Elephant implements ZooAnimal{

    private long id;

    private String name;

    private int length;

    private long weight;

    public Elephant(String name, int length, long weight) {
        this.name = name;
        this.length = length;
        this.weight = weight;
    }

    public Elephant(long id, String name, int length, long weight) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public long getWeight() {
        return weight;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public AnimalType getType() {
        return AnimalType.ELEPHANT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elephant elephant = (Elephant) o;
        return Objects.equals(name, elephant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
