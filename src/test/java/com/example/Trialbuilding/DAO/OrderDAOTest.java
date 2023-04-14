
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
    public void testGetReturnsCorrectValue() {
        Order order = new Order();
        Mockito.when(longOrderMap.get(0L)).thenReturn(order);
        Assert.assertEquals(order, orderDAO.get(0L).get());
    }

    @Test
    public void testGetAllReturnsCorrectValue() {
        List<Order> orders = new ArrayList<>();
        Mockito.when(longOrderMap.values()).thenReturn(orders);
        Assert.assertEquals(orders, orderDAO.getAll());
    }

    @Test
    public void testSaveReturnsCorrectValue() {
        Order order = new Order();
        Mockito.when(longOrderMap.put(0L, order)).thenReturn(order);
        Assert.assertEquals(order, orderDAO.save(order));
    }

    @Test
    public void testUpdateReturnsCorrectValue() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(longOrderMap.get(0L)).thenReturn(order);
        Assert.assertEquals(order, orderDAO.update(0L, order));
    }

    @Test
    public void testUpdateReturnsCorrectException() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(longOrderMap.get(0L)).thenReturn(null);
        try {
            orderDAO.update(0L, order);
            Assert.fail();
        } catch (ContentNotFoundException e) {
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void testDeleteReturnsCorrectValue() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(longOrderMap.get(0L)).thenReturn(order);
        Mockito.when(longOrderMap.remove(0L)).thenReturn(order);
        Assert.assertEquals(order, orderDAO.delete(0L));
    }

    @Test
    public void testDeleteReturnsCorrectException() throws ContentNotFoundException {
        Order order = new Order();
        Mockito.when(longOrderMap.get(0L)).thenReturn(null);
        try {
            orderDAO.update(0L, order);
            Assert.fail();
        } catch (ContentNotFoundException e) {
            Assert.assertNotNull(e);
        }
    }
}
