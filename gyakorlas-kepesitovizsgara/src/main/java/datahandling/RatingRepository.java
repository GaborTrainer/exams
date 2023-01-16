package datahandling;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RatingRepository {

    private JdbcTemplate jdbcTemplate;

    public RatingRepository(MariaDbDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Long save(Rating rating) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("insert into ratings(id, nickname, month, task_nr, rating) values (?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            setStatementParametersByRating(rating, ps);
            return ps;
        }, holder);

        return Objects.requireNonNull(holder.getKey()).longValue();
    }

    private void setStatementParametersByRating(Rating rating, PreparedStatement stmt) throws SQLException {
        stmt.setLong(1, rating.getId());
        stmt.setString(2, rating.getNickname());
        stmt.setInt(3, rating.getMonth());
        stmt.setInt(4, rating.getTaskNr());
        stmt.setInt(5, rating.getRatingValue());
    }

    public int getMonthFullScore(String name, int month) {
        return jdbcTemplate.query("SELECT SUM(rating) AS sum_of_ratings FROM ratings WHERE nickname = ? AND month = ? ",
                (rs,rn) -> rs.getInt("sum_of_ratings"),
                name, month).get(0);
    }

    public Map<String, Integer> getRatingsByTask(int month, int taskNr){
        Map<String, Integer> result = new HashMap<>();
        jdbcTemplate.query("SELECT nickname, rating FROM ratings WHERE month = ? AND  task_nr = ?",
                (rs,rn) -> result.put(rs.getString("nickname"), rs.getInt("rating")),
                month, taskNr);
        return result;
    }
}
