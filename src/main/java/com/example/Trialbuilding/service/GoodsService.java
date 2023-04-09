package com.example.Trialbuilding.service;

import com.example.Trialbuilding.DAO.GoodsDAO;
import com.example.Trialbuilding.entity.Goods;
import com.example.Trialbuilding.exceptions.ContentNotFoundException;
import com.example.Trialbuilding.exceptions.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsService {
    @Autowired
    GoodsDAO goodsDAO;

    @Transactional
    public Goods getGoods(Long id) throws ContentNotFoundException {
        Optional<Goods> optionalGoods = goodsDAO.get(id);
        if (optionalGoods.isPresent()) {
            return optionalGoods.get();
        } else {
            throw new ContentNotFoundException();
        }
    }

    @Transactional
    public List<Goods> getAllGoods() throws NoContentException {
        if (!goodsDAO.getAll().isEmpty()) {
            return goodsDAO.getAll();
        } else {
            throw new NoContentException();
        }
    }

    @Transactional
    public Goods saveGoods(Goods goods) {
        return goodsDAO.save(goods);
    }

    @Transactional
    public Goods updateGoods(Long id, Goods goods) throws ContentNotFoundException {
        return goodsDAO.update(id, goods);
    }

    @Transactional
    public Goods deleteGoods(Long id) throws ContentNotFoundException {
        return goodsDAO.delete(id);
    }
}
