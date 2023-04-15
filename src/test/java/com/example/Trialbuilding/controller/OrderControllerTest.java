package com.example.Trialbuilding.controller;

import com.example.Trialbuilding.entity.Order;
import com.example.Trialbuilding.exceptions.ContentNotFoundException;
import com.example.Trialbuilding.exceptions.NoContentException;
import com.example.Trialbuilding.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderControllerTest {

    @Mock
    OrderService orderService;

    @InjectMocks
    OrderController orderController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllOrdersCorrectValueAndStatus() throws NoContentException {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order());
        Mockito.when(orderService.getAllOrders()).thenReturn(orders);
        Assert.assertEquals(HttpStatus.OK, orderController.findAllOrders().getStatusCode());
        Assert.assertEquals(orders, orderController.findAllOrders().getBody());
    }

    @Test
    public void testFindAllOrdersCorrectExceptionAndStatus() throws NoContentException {
        Mockito.when(orderService.getAllOrders()).thenThrow(new NoContentException());
        Assert.assertEquals(HttpStatus.NO_CONTENT, orderController.findAllOrders().getStatusCode());
        Assert.assertEquals(null, orderController.findAllOrders().getBody());
    }

    @Test
    public void testFindOrderCorrectValueAndStatus() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(orderService.getOrder(0L)).thenReturn(order);
        Assert.assertEquals(HttpStatus.OK, orderController.findOrder(0L).getStatusCode());
        Assert.assertEquals(order, orderController.findOrder(0L).getBody());
    }

    @Test
    public void testFindOrderCorrectExceptionAndStatus() throws ContentNotFoundException {
        Mockito.when(orderService.getOrder(0L)).thenThrow(new ContentNotFoundException());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, orderController.findOrder(0L).getStatusCode());
        Assert.assertEquals(null, orderController.findOrder(0L).getBody());
    }

    @Test
    public void testDeleteOrderCorrectValueAndStatus() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(orderService.deleteOrder(0L)).thenReturn(order);
        Assert.assertEquals(HttpStatus.OK, orderController.deleteOrder(0L).getStatusCode());
        Assert.assertEquals(order, orderController.deleteOrder(0L).getBody());
    }

    @Test
    public void testDeleteOrderCorrectExceptionAndStatus() throws ContentNotFoundException {
        Mockito.when(orderService.deleteOrder(0L)).thenThrow(new ContentNotFoundException());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, orderController.deleteOrder(0L).getStatusCode());
        Assert.assertEquals(null, orderController.deleteOrder(0L).getBody());
    }

    @Test
    public void testAddOrderCorrectValueAndStatus() {
        Order order = new Order();
        Mockito.when(orderService.saveOrder(order)).thenReturn(order);
        Assert.assertEquals(HttpStatus.OK, orderController.addOrder(order).getStatusCode());
        Assert.assertEquals(order, orderController.addOrder(order).getBody());
    }

    @Test
    public void testUpdateOrderCorrectValueAndStatus() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(orderService.updateOrder(0L, order)).thenReturn(order);
        Assert.assertEquals(HttpStatus.OK, orderController.updateOrder(0L, order).getStatusCode());
        Assert.assertEquals(order, orderController.updateOrder(0L, order).getBody());
    }

    @Test
    public void testUpdateOrderCorrectExceptionAndStatus() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(orderService.updateOrder(0L, order)).thenThrow(new ContentNotFoundException());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, orderController.updateOrder(0L, order).getStatusCode());
        Assert.assertEquals(null, orderController.updateOrder(0L, order).getBody());
    }

}