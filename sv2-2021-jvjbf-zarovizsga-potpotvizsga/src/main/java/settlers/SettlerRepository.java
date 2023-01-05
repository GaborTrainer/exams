package settlers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SettlerRepository {

    private JdbcTemplate jdbcTemplate;

    public SettlerRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long saveNewSettler(Settler settler) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO settlers (name_of_settler, expected_income) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, settler.getNameOfSettler());
            ps.setDouble(2, settler.getExpectedIncome());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public Settler findSettlerById(long id) {
        return jdbcTemplate.query("select * from settlers where id = ?",
                (rs, rowNum) -> new Settler(rs.getString("name_of_settler"), rs.getInt("amount_of_tobacco")), id).get(0);
    }

    public void updateGrowthAndIncome(long id, int amount) {
        jdbcTemplate.update(
                "update settlers set amount_of_tobacco = amount_of_tobacco - ?, expected_income = expected_income - ? where id = ?;",
                amount, amount * Settler.YIELD_PRICE, id);
    }
}