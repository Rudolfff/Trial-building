package com.example.Trialbuilding.service;

import com.example.Trialbuilding.DAO.OrderDAO;
import com.example.Trialbuilding.entity.Order;
import com.example.Trialbuilding.exceptions.ContentNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsServiceTest {

    @Mock
    public OrderDAO orderDAO;

    @InjectMocks
    public OrderService orderService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMyServiceMethod() throws ContentNotFoundException {
        Optional<Order> optionalOrder = Optional.of(new Order());

        // arrange
        Mockito.when(orderDAO.get(1L)).thenReturn(optionalOrder);

        // act
        Order result = orderService.getOrder(1L);

        Assert.assertEquals(optionalOrder.get(), result);
    }
/*
    @Test
    void getAllGoods() {
    }

    @Test
    void saveGoods() {
    }

    @Test
    void updateGoods() {
    }

    @Test
    void deleteGoods() {
    }*/
}