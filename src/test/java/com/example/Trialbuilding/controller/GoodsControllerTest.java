package com.example.Trialbuilding.controller;

import com.example.Trialbuilding.entity.Goods;
import com.example.Trialbuilding.exceptions.ContentNotFoundException;
import com.example.Trialbuilding.exceptions.NoContentException;
import com.example.Trialbuilding.service.GoodsService;
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
public class GoodsControllerTest {

    @Mock
    GoodsService goodsService;

    @InjectMocks
    GoodsController goodsController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllGoodsCorrectValueAndStatus() throws NoContentException {
        ArrayList<Goods> goodsArrayList = new ArrayList<>();
        goodsArrayList.add(new Goods());
        Mockito.when(goodsService.getAllGoods()).thenReturn(goodsArrayList);
        Assert.assertEquals(HttpStatus.OK, goodsController.findAllGoods().getStatusCode());
        Assert.assertEquals(goodsArrayList, goodsController.findAllGoods().getBody());
    }

    @Test
    public void testFindAllGoodsCorrectExceptionAndStatus() throws NoContentException {
        Mockito.when(goodsService.getAllGoods()).thenThrow(new NoContentException());
        Assert.assertEquals(HttpStatus.NO_CONTENT, goodsController.findAllGoods().getStatusCode());
        Assert.assertEquals(null, goodsController.findAllGoods().getBody());
    }

    @Test
    public void testFindGoodsCorrectValueAndStatus() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(goodsService.getGoods(0L)).thenReturn(goods);
        Assert.assertEquals(HttpStatus.OK, goodsController.findGoods(0L).getStatusCode());
        Assert.assertEquals(goods, goodsController.findGoods(0L).getBody());
    }

    @Test
    public void testFindGoodsCorrectExceptionAndStatus() throws ContentNotFoundException {
        Mockito.when(goodsService.getGoods(0L)).thenThrow(new ContentNotFoundException());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, goodsController.findGoods(0L).getStatusCode());
        Assert.assertEquals(null, goodsController.findGoods(0L).getBody());
    }

    @Test
    public void testDeleteGoodsCorrectValueAndStatus() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(goodsService.deleteGoods(0L)).thenReturn(goods);
        Assert.assertEquals(HttpStatus.OK, goodsController.findGoods(0L).getStatusCode());
        Assert.assertEquals(goods, goodsController.deleteGoods(0L).getBody());
    }

    @Test
    public void testDeleteGoodsCorrectExceptionAndStatus() throws ContentNotFoundException {
        Mockito.when(goodsService.deleteGoods(0L)).thenThrow(new ContentNotFoundException());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, goodsController.deleteGoods(0L).getStatusCode());
        Assert.assertEquals(null, goodsController.deleteGoods(0L).getBody());
    }

    @Test
    public void testAddGoodsCorrectValueAndStatus() {
        Goods goods = new Goods();
        Mockito.when(goodsService.saveGoods(goods)).thenReturn(goods);
        Assert.assertEquals(HttpStatus.OK, goodsController.addGoods(goods).getStatusCode());
        Assert.assertEquals(goods, goodsController.addGoods(goods).getBody());
    }

    @Test
    public void testUpdateGoodsCorrectValueAndStatus() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(goodsService.updateGoods(0L, goods)).thenReturn(goods);
        Assert.assertEquals(HttpStatus.OK, goodsController.updateGoods(0L, goods).getStatusCode());
        Assert.assertEquals(goods, goodsController.updateGoods(0L, goods).getBody());
    }

    @Test
    public void testUpdateGoodsCorrectExceptionAndStatus() throws ContentNotFoundException {
        Goods goods = new Goods();
        Mockito.when(goodsService.updateGoods(0L, goods)).thenThrow(new ContentNotFoundException());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, goodsController.updateGoods(0L, goods).getStatusCode());
        Assert.assertEquals(null, goodsController.updateGoods(0L, goods).getBody());
    }
}