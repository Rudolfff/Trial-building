package com.example.Trialbuilding.controller;

import com.example.Trialbuilding.entity.Goods;
import com.example.Trialbuilding.exceptions.ContentNotFoundException;
import com.example.Trialbuilding.exceptions.NoContentException;
import com.example.Trialbuilding.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/all")
    public ResponseEntity<List<Goods>> findAllGoods() {
        try {
            return new ResponseEntity<> (goodsService.getAllGoods(), HttpStatus.OK);
        } catch (NoContentException e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Goods> findGoods(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(goodsService.getGoods(id), HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Goods> deleteGoods(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(goodsService.deleteGoods(id), HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Goods> addGoods(@RequestBody Goods goods) {
        return new ResponseEntity<>(goodsService.saveGoods(goods), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Goods> updateGoods(@PathVariable Long id, @RequestBody Goods goods) {
        try {
            return new ResponseEntity<>(goodsService.updateGoods(id, goods), HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
