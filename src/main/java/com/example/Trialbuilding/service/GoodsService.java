package com.example.Trialbuilding.service;

import com.example.Trialbuilding.DAO.GoodsDAO;
import com.example.Trialbuilding.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsDAO goodsDAO;

    public Goods getGoods(Long id) {
        return goodsDAO.get(id).orElse(null);
    }

    public List<Goods> getAllGoods() {
        return goodsDAO.getAll();
    }

    public Goods saveGoods(Goods goods) {
        return goodsDAO.save(goods);
    }

    public Goods goodsUpdate(Long id, Goods goods) throws Exception {
        return goodsDAO.update(id, goods);
    }

    public void deleteGoods(Goods goods) throws Exception {
        goodsDAO.delete(goods);
    }
}
