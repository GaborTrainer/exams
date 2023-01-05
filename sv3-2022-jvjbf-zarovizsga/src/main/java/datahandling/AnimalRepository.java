package datahandling;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class AnimalRepository {

    private JdbcTemplate jdbcTemplate;

    public AnimalRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveAnimal(Animal animal) {
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement( "insert into animals " +
                    "(species, number_of_animals, date_of_observation) values(?,?,?)");
            ps.setString(1, animal.getAnimalType());
            ps.setInt(2, animal.getCountOfAnimal());
            ps.setDate(3, Date.valueOf(animal.getDateOfObservation()));
            return ps;
        });
    }

    public List<Animal> findAllAnimals() {
        return jdbcTemplate.query("select * from animals",
                (rs, rowNum) -> new Animal(rs.getLong("id"), rs.getString("species"),
                        rs.getInt("number_of_animals"), rs.getDate("date_of_observation").toLocalDate()));
    }

    public int countAllByAnimalType(String species) {
        List<Animal> animals = jdbcTemplate.query("select * from animals where species = ?",
                (rs, rowNum) -> new Animal(rs.getLong("id"), rs.getString("species"),
                        rs.getInt("number_of_animals"), rs.getDate("date_of_observation").toLocalDate()), species);
        int count = animals.stream()
                .mapToInt(Animal::getCountOfAnimal)
                .sum();
        if (count == 0) {
            throw new IllegalArgumentException("No animal found!");
        }
        return count;
    }
}
