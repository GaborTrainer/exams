package jurassic;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JurassicPark {

    private final JdbcTemplate jdbcTemplate;

    public JurassicPark(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> checkOverpopulation() {
        String query = "SELECT breed FROM dinosaur WHERE expected < actual ORDER BY breed ASC;";
        RowMapper<String> rowMapper = (rs, rowNum) -> rs.getString("breed");
        return jdbcTemplate.query(query, rowMapper);
    }
}