package com.example.Trialbuilding.service;

import com.example.Trialbuilding.DAO.OrderDAO;
import com.example.Trialbuilding.entity.Order;
import com.example.Trialbuilding.exceptions.ContentNotFoundException;
import com.example.Trialbuilding.exceptions.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Transactional
    public Order getOrder(Long id) throws ContentNotFoundException {
        Optional<Order> optionalOrder = orderDAO.get(id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        } else {
            throw new ContentNotFoundException();
        }
    }

    @Transactional
    public List<Order> getAllOrders() throws NoContentException {
        if (!orderDAO.getAll().isEmpty()) {
            return orderDAO.getAll();
        } else {
            throw new NoContentException();
        }
    }

    @Transactional
    public Order saveOrder(Order order) {
        return orderDAO.save(order);
    }

    @Transactional
    public Order updateOrder(Long id, Order order) throws ContentNotFoundException {
        return orderDAO.update(id, order);
    }

    @Transactional
    public Order deleteOrder(Long id) throws ContentNotFoundException {
        return orderDAO.delete(id);
    }
}
