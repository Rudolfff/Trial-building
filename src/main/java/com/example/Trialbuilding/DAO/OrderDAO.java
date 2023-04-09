package com.example.Trialbuilding.DAO;

import com.example.Trialbuilding.entity.Order;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OrderDAO implements Dao<Order> {
    Map<Long, Order> orders = new HashMap<>();
    Long id = -1L;

    public OrderDAO() {
        orders.put(-1L, new Order(-1L, "Test Client", new Date(2000202020201L), "Test address"));
    }

    @Override
    public Optional<Order> get(Long id) {
        return Optional.ofNullable(orders.get(id));
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order save(Order order) {
        return orders.put(id++, order);
    }

    @Override
    public Order update(Long id, Order order) throws Exception {
        Optional<Order> optionalOrder = get(id);
        Order orderUpdate = null;
        if (!optionalOrder.isPresent()) {
            throw new Exception("Not find");
        } else {
            orderUpdate = optionalOrder.get();
            updateCheck(order, orderUpdate);
        }
        return orderUpdate;
    }

    @Override
    public void delete(Order order) throws Exception {
        if (!orders.containsValue(order)) {
            throw new Exception("Not find");
        }
        orders.remove(order.getId());
    }

    private void updateCheck(Order order, Order orderUpdate) {
        if (order.getAddress() != null) {
            orderUpdate.setAddress(order.getAddress());
        }
        if (order.getDate() != null) {
            orderUpdate.setDate(order.getDate());
        }
        if (order.getClient() != null) {
            orderUpdate.setClient(order.getClient());
        }
    }
}
