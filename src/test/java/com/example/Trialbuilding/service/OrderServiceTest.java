package com.example.Trialbuilding.service;

import com.example.Trialbuilding.DAO.OrderDAO;
import com.example.Trialbuilding.entity.Order;
import com.example.Trialbuilding.exceptions.ContentNotFoundException;
import com.example.Trialbuilding.exceptions.NoContentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {
    @Mock
    public OrderDAO orderDAO;

    @InjectMocks
    public OrderService orderService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetReturnsCorrectValue() throws ContentNotFoundException {
        Optional<Order> optionalOrder = Optional.of(new Order());
        Mockito.when(orderDAO.get(0L)).thenReturn(optionalOrder);
        Assert.assertEquals(optionalOrder.get(), orderService.getOrder(0L));
    }

    public void testGetReturnsCorrectException() throws ContentNotFoundException {
        Optional<Order> optionalOrder = Optional.of(new Order());
        Mockito.when(orderDAO.get(0L)).thenReturn(optionalOrder);
        try {
            orderService.getOrder(0L);
            Assert.fail();
        } catch (ContentNotFoundException e) {
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void testGetAllOrdersReturnsCorrectValue() throws NoContentException {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        Mockito.when(orderDAO.getAll()).thenReturn(orders);
        Assert.assertEquals(orders, orderService.getAllOrders());
    }

    @Test
    public void testGetAllOrdersReturnsCorrectException() throws NoContentException {
        List<Order> orders = new ArrayList<>();
        Mockito.when(orderDAO.getAll()).thenReturn(orders);
        try {
            orderService.getAllOrders();
            Assert.fail();
        } catch (NoContentException e) {
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void testSaveOrderCorrectValue() {
        Order order = new Order();
        Mockito.when(orderDAO.save(order)).thenReturn(order);
        Assert.assertEquals(order, orderService.saveOrder(order));
    }

    @Test
    public void testUpdateOrderCorrectValue() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(orderDAO.update(0L, order)).thenReturn(order);
        Assert.assertEquals(order, orderService.updateOrder(0L, order));
    }

    @Test
    public void testDeleteOrderCorrectValue() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(orderDAO.delete(0L)).thenReturn(order);
        Assert.assertEquals(order, orderService.deleteOrder(0L));
    }
}
