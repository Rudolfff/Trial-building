/*
package com.example.Trialbuilding.DAO;

import com.example.Trialbuilding.entity.Goods;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

public class GoodsDAOTest extends TestCase {
    @Mock
    private GoodsDAO goodsDAO;

    @InjectMocks
    private Goods goods;


    @Test
    public void testGet() {
        Long id = goodsDAO.id;
        goods = new Goods(++id, "StringTest", 999);
        goodsDAO.save(goods);
        Optional<Goods> optionalGoods = Optional.of(goods);
        Optional<Goods> result = goodsDAO.get(id);
        assertEquals(result, optionalGoods);
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }

    @org.junit.jupiter.api.Test
    void save() {
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }
}
*/
