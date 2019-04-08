package com.book.mall.mall.service;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.resbean.SimpleBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public Goods getById(Long id) {
        Goods goods =  goodsMapper.getById(id);

        SimpleBook sb = new SimpleBook();
        sb.setId(goods.getId());
        sb.setName(goods.getName());

        return goods;
    }

    public void addGoods(Goods goods){
        if(goods.getNumber() == null){
            goods.setNumber(0);
        }

        if(goods.getStock() == null) {
            goods.setStock(0);
        }

        if(goods.getRemark() == null) {
            goods.setRemark("");
        }
        goodsMapper.addGoods(goods);
    }

    public void delGood(Long id){
        goodsMapper.delById(id);
    }

    public void updateGoods(Goods goods){
        goodsMapper.updateGoods(goods);
    }
}
