package datahandling;

import java.util.*;

public class OrderService {

    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Long saveOrder(Order order) {
        return repository.saveOrder(order);
    }

    public int getMostExpensiveOrderPrice() {
        return repository.getMostExpensiveOrderPrice();
    }

    public List<Order> getOrders() {
        return repository.getOrders();
    }

    public Map<String, Integer> collectProductsAndCount() {
        Map<String, Integer> result = new HashMap<>();
        List<Order> orders = getOrders();

        for (Order order : orders) {
            String key = order.getProductName();
            if (!result.containsKey(key)) {
                result.put(key, 0);
            }
            result.put(key, result.get(key) + order.getProductCount());
        }
        return result;
    }
}
