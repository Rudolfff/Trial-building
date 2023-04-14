
package com.example.Trialbuilding.DAO;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderDAOTest {

    @Mock
    private Map<Long, Order> longOrderMap;
    @InjectMocks
    private OrderDAO orderDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void get() {
        Order order = new Order();
        Mockito.when(longOrderMap.get(0L)).thenReturn(order);
        Assert.assertEquals(order, orderDAO.get(0L).get());
    }

    @Test
    public void getAll() {
        List<Order> orders = new ArrayList<>();
        Mockito.when(longOrderMap.values()).thenReturn(orders);
        Assert.assertEquals(orders, orderDAO.getAll());
    }

    @Test
    public void save() {
        Order order = new Order();
        Mockito.when(longOrderMap.put(0L, order)).thenReturn(order);
        Assert.assertEquals(order, orderDAO.save(order));
    }

    @Test
    public void update() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(longOrderMap.get(0L)).thenReturn(order);
        Assert.assertEquals(order, orderDAO.update(0L, order));
    }

    @Test
    public void delete() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(longOrderMap.get(0L)).thenReturn(order);
        Mockito.when(longOrderMap.remove(0L)).thenReturn(order);
        Assert.assertEquals(order, orderDAO.delete(0L));
    }
}
