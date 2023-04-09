package com.example.Trialbuilding.DAO;

import com.example.Trialbuilding.entity.Goods;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GoodsDAO implements Dao<Goods>{
    Map<Long, Goods> goods = new HashMap<>();
    Long id = -1L;

    public GoodsDAO () {
        goods.put(-1L, new Goods(-1L, "String name", 999));
    }

    @Override
    public Optional<Goods> get(Long id) {
        return Optional.ofNullable(goods.get(id));
    }

    @Override
    public List<Goods> getAll() {
        return new ArrayList<Goods>(goods.values());
    }

    @Override
    public Goods save(Goods good) {
        good.setId(++id);
        return goods.put(id, good);
    }

    @Override
    public Goods update(Long id, Goods value) throws Exception {
        Optional<Goods> optionalGoods = get(id);
        Goods goodsUpdate = null;
        if (!optionalGoods.isPresent()) {
            throw new Exception("Not found");
        } else {
            goodsUpdate = optionalGoods.get();
            updateCheck(value, goodsUpdate);
        }
        return goodsUpdate;
    }

    @Override
    public Goods delete(Goods good) throws Exception {
        if (!goods.containsValue(good)) {
            throw new Exception("Not find");
        }
        return goods.remove(good.getId());
    }
    private void updateCheck(Goods value, Goods goodsUpdate) {
        if (value.getName() != null) {
            goodsUpdate.setName(value.getName());
        }
        if (value.getPrice() != null) {
            goodsUpdate.setPrice(value.getPrice());
        }
    }
}
