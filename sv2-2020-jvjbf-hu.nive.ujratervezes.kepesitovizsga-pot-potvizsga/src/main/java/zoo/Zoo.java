package zoo;

import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class Zoo {

    private Set<ZooAnimal> animals = new HashSet<>();

    private DataSource dataSource;

    public Zoo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Zoo() {
    }

    public Set<ZooAnimal> getAnimals() {
        return new HashSet<>(animals);
    }


    public void addAnimal(ZooAnimal zooAnimal) {
        animals.add(zooAnimal);
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {
        return animals.stream().max(Comparator.comparing(ZooAnimal::getWeight)).orElseThrow();
    }

    public int countWeights() {
        return (int) animals.stream()
                .mapToLong(ZooAnimal::getWeight)
                .sum();
    }

    public ZooAnimal findExactAnimal(ZooAnimal animal) {
        return animals.stream()
                .filter(zooAnimal -> zooAnimal.equals(animal))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public ZooAnimal findExactAnimalByName(String name) {
        return animals.stream()
                .filter(zooAnimal -> zooAnimal.getName().equals(name))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public List<ZooAnimal> getAnimalsOrderedByName() {
        return animals.stream()
                .sorted(Comparator.comparing(ZooAnimal::getName))
                .toList();
    }

    public Map<AnimalType, Integer> getAnimalStatistics() {
        return animals.stream()
                .collect(Collectors.groupingBy(ZooAnimal::getType, Collectors.summingInt(e -> 1)));
    }

    public void loadAnimals() {
        try (Connection conn = (Connection) dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from animals;")) {
            while (rs.next()) {
                getAnimal(rs);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get data.", sqle);
        }
    }

    private void getAnimal(ResultSet rs) throws SQLException {
        String type = "animal_type";
        String name = "animal_name";
        String length = "length_of_member";

        if (rs.getString(type).equals("LION")) {
            animals.add(new Lion(rs.getString(name)));
        } else if (rs.getString(type).equals("GIRAFFE")) {
            animals.add(new Giraffe(rs.getString(name), rs.getInt(length)));
        } else if ((rs.getString(type).equals("ELEPHANT"))) {
            animals.add(new Elephant(rs.getString(name), rs.getInt(length), rs.getLong("weight")));
        } else {
            throw new IllegalArgumentException("There is no such animal type in this Zoo!");
        }
    }

    public void addAnimalToDatabase(ZooAnimal animal) {
        try (Connection conn = (Connection) dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into animals(id, animal_name, length_of_member, weight) values (?, ?, ?, ?);")) {

                stmt.setLong(1, animal.getId());
                stmt.setString(2, animal.getName());
                stmt.setDouble(3, animal.getLength());
                stmt.setDouble(4, animal.getWeight());

                stmt.executeUpdate();
            } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
