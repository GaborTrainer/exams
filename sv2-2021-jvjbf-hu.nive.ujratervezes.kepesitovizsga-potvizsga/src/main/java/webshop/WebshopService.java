package webshop;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class WebshopService {

    private JdbcTemplate jdbcTemplate;

    public WebshopService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<String> getValuableCustomers() {
            List<String> result =  jdbcTemplate.query("select customer_name from orders where total > 1000",
                    (rs, rowNum) -> rs.getString("customer_name"));
            return result.stream().sorted().toList();
        }
    }
