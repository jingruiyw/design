package com.book.mall.mall.service;

import com.book.mall.mall.entity.Goods;
import com.book.mall.mall.mapper.GoodsMapper;
import com.book.mall.mall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public List<Goods> findAll(){
        List<Goods> goods = goodsMapper.findAll();
        for(Goods good : goods) {
            good.setCreateTime(DateUtil.formatDate(Long.parseLong(good.getCreateTime())));
        }
        return goods;
    }

    public Goods getById(Long id) {
        Goods goods =  goodsMapper.getById(id);

        String createTime = goods.getCreateTime();
        Long time = Long.parseLong(createTime);
        goods.setCreateTime(DateUtil.formatDate(time));

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
