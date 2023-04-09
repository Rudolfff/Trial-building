package com.example.Trialbuilding.controller;

import com.example.Trialbuilding.entity.Order;
import com.example.Trialbuilding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> findAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/one/{id}")
    public Order findOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        try {
            return orderService.updateOrder(id, order);
        } catch (Exception e) {
            return null;
        }
    }
}
