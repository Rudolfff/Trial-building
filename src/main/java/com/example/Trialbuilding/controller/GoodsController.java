package com.example.Trialbuilding.controller;

import com.example.Trialbuilding.entity.Goods;
import com.example.Trialbuilding.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/all")
    public List<Goods> findAllGoods() {
        return goodsService.getAllGoods();
    }

    @GetMapping("/one/{id}")
    public Goods findGoods(@PathVariable Long id) {
        return goodsService.getGoods(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGoods(@PathVariable Long id) {
        try {
            goodsService.deleteGoods(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/add")
    public Goods addGoods(@RequestBody Goods goods) {
        return goodsService.saveGoods(goods);
    }

    @PutMapping("/update/{id}")
    public Goods updateGoods(@PathVariable Long id, @RequestBody Goods goods) {
        try {
            return goodsService.updateGoods(id, goods);
        } catch (Exception e) {
            return null;
        }
    }
}
