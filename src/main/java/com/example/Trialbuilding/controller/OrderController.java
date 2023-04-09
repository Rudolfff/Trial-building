package com.example.Trialbuilding.controller;

import com.example.Trialbuilding.entity.Order;
import com.example.Trialbuilding.exceptions.ContentNotFoundException;
import com.example.Trialbuilding.exceptions.NoContentException;
import com.example.Trialbuilding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> findAllOrders() {
        try {
            return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
        } catch (NoContentException e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Order> findOrder(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        try {
            return new ResponseEntity<> (orderService.updateOrder(id, order), HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
