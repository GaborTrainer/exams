package datahandling;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OrderRepository {

    private JdbcTemplate jdbcTemplate;

    public OrderRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Long saveOrder(Order order) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(
                        "insert into orders " +
                            "(product_name, product_count, price_per_product)" +
                            " values (?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getProductName());
            ps.setInt(2, order.getProductCount());
            ps.setInt(3, order.getPricePerProduct());
            return ps;
        }, holder);

        return Objects.requireNonNull(holder.getKey()).longValue();
    }

    public List<Order> getOrders() {
        List<Order> orders = jdbcTemplate.query("select * from orders",
                (rs, rowNum) -> new Order(rs.getLong("id"), rs.getString("product_name"),
                rs.getInt("product_count"), rs.getInt("price_per_product")));
        return orders.stream()
                .sorted(Comparator.comparing(Order::getProductName))
                .toList();
    }

    public int getMostExpensiveOrderPrice() {
        return jdbcTemplate.queryForObject("select max(product_count*price_per_product) from orders",
                (rs, rn) -> rs.getInt(1));
    }
}
