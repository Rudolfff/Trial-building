package com.example.Trialbuilding.service;

import com.example.Trialbuilding.DAO.GoodsDAO;
import com.example.Trialbuilding.entity.Goods;
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
public class GoodsServiceTest {

    @Mock
    public GoodsDAO goodsDAO;

    @InjectMocks
    public GoodsService goodsService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetReturnsCorrectValue() throws ContentNotFoundException {
        Optional<Goods> optionalGoods = Optional.of(new Goods());
        // arrange
        Mockito.when(goodsDAO.get(1L)).thenReturn(optionalGoods);
        // act
        Goods result = goodsService.getGoods(1L);
        Assert.assertEquals(optionalGoods.get(), result);
    }

    @Test
    public void testGetReturnsCorrectException() throws ContentNotFoundException {
        Optional<Goods> optionalGoods = Optional.ofNullable(null);
        Mockito.when(goodsDAO.get(1L)).thenReturn(optionalGoods);
        try {
            goodsService.getGoods(1L);
            Assert.fail();
        } catch (ContentNotFoundException e) {
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void testGetAllGoodsReturnsCorrectValue() throws NoContentException {
        List<Goods> goodsArrayList = new ArrayList<>();
        goodsArrayList.add(new Goods());
        Mockito.when(goodsDAO.getAll()).thenReturn(goodsArrayList);
        Assert.assertEquals(goodsArrayList, goodsService.getAllGoods());
    }

    @Test
    public void testGetAllGoodsReturnsException() throws NoContentException {
        List<Goods> goodsList = new ArrayList<>();
        Mockito.when(goodsDAO.getAll()).thenReturn(goodsList);
        try {
            goodsService.getAllGoods();
            Assert.fail("Error--");
        } catch (NoContentException e) {
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void testSaveGoodsCorrectValue() {
        Goods goods = new Goods();
        Mockito.when(goodsDAO.save(goods)).thenReturn(goods);
        Assert.assertEquals(goods, goodsService.saveGoods(goods));
    }

    @Test
    public void testUpdateGoodsCorrectValue() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(goodsDAO.update(0L, goods)).thenReturn(goods);
        Assert.assertEquals(goods, goodsService.updateGoods(0L, goods));
    }

    @Test
    public void testDeleteGoodsCorrectValue() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(goodsDAO.delete(0L)).thenReturn(goods);
        Assert.assertEquals(goods, goodsService.deleteGoods(0L));
    }
}