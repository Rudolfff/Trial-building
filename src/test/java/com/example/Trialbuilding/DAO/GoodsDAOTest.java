
package com.example.Trialbuilding.DAO;

import com.example.Trialbuilding.entity.Goods;
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
public class GoodsDAOTest {
    @Mock
    private Map<Long, Goods> longGoodsMap;

    @InjectMocks
    private GoodsDAO goodsDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetReturnsCorrectValue() {
        Goods goods = new Goods();
        Mockito.when(longGoodsMap.get(0L)).thenReturn(goods);
        Assert.assertEquals(goods, goodsDAO.get(0L).get());
    }

    @Test
    public void testGetAllReturnsCorrectValue() {
        List<Goods> goodsList = new ArrayList<>();
        Mockito.when(longGoodsMap.values()).thenReturn(goodsList);
        Assert.assertEquals(goodsList, goodsDAO.getAll());
    }

    @Test
    public void testSaveReturnsCorrectValue() {
        Goods goods = new Goods();
        Mockito.when(longGoodsMap.put(0L, goods)).thenReturn(goods);
        Assert.assertEquals(goods, goodsDAO.save(goods));
    }

    @Test
    public void testUpdateReturnsCorrectValue() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(longGoodsMap.get(0L)).thenReturn(goods);
        Assert.assertEquals(goods, goodsDAO.update(0L, goods));
    }

    @Test
    public void testUpdateReturnsCorrectException() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(longGoodsMap.get(0L)).thenReturn(null);
        try {
            goodsDAO.update(0L, goods);
            Assert.fail();
        } catch (ContentNotFoundException e) {
            Assert.assertNotNull(e);
        }
    }
    @Test
    public void testDeleteReturnsCorrectValue() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(longGoodsMap.get(0L)).thenReturn(goods);
        Mockito.when(longGoodsMap.remove(0L)).thenReturn(goods);
        Assert.assertEquals(goods, goodsDAO.delete(0L));
    }

    @Test
    public void testDeleteReturnsCorrectException() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(longGoodsMap.get(0L)).thenReturn(null);
        try {
            goodsDAO.update(0L, goods);
            Assert.fail();
        } catch (ContentNotFoundException e) {
            Assert.assertNotNull(e);
        }
    }
}

