package message;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertUser(String username) {
        jdbcTemplate.update("insert into users (username) values(?)", username);
    }

    public Optional<User> findUserByName(String username) {
        List<User> result = jdbcTemplate.query("select * from users where username = ?",
                (rs, rowNum) -> new User(rs.getLong("id"),rs.getString("username")), username);

        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }
}
