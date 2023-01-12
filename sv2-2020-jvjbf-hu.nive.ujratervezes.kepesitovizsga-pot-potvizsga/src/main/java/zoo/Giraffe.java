package zoo;

import java.util.Objects;

public class Giraffe implements ZooAnimal{

    private long id;

    private String name;

    private int length;

    public Giraffe(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Giraffe(long id, String name, int length) {
        this.id = id;
        this.name = name;
        this.length = length;
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
        return 0;
    }

    @Override
    public AnimalType getType() {
        return AnimalType.GIRAFFE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giraffe giraffe = (Giraffe) o;
        return Objects.equals(name, giraffe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public long getId() {
        return id;
    }
}
