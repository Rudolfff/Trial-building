package com.example.Trialbuilding.service;

import com.example.Trialbuilding.DAO.OrderDAO;
import com.example.Trialbuilding.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    public Order getOrder(Long id) {
        return orderDAO.get(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAll();
    }

    public Order saveOrder(Order order) {
        return orderDAO.save(order);
    }

    public Order updateOrder(Long id, Order order) throws Exception {
        return orderDAO.update(id, order);
    }

    public Order deleteOrder(Long id) throws Exception {
        return orderDAO.delete(orderDAO.get(id).get());
    }
}
