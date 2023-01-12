package zoo;

import java.util.Objects;

public class Lion implements ZooAnimal {

    private long id;

    private String name;

    public Lion(String name) {
        this.name = name;
    }

    public Lion(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public long getWeight() {
        return 0;
    }

    @Override
    public AnimalType getType() {
        return AnimalType.LION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lion lion = (Lion) o;
        return Objects.equals(name, lion.name);
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
